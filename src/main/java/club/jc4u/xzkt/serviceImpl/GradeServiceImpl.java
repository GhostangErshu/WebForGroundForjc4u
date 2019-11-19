package club.jc4u.xzkt.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import club.jc4u.xzkt.entity.Grade;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.User;
import club.jc4u.xzkt.mapper.GradeMapper;
import club.jc4u.xzkt.mapper.TaskMapper;
import club.jc4u.xzkt.mapper.UserMapper;
import club.jc4u.xzkt.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TaskMapper taskMapper;

	private ResponseForm res;

	/**
	 * just query the total score
	 */
	@Override
	public ResponseForm getGradeById(String id) {
		res = new ResponseForm();
		if (id != null && id.length() != 0) {
			Integer grade = gradeMapper.selSumOfGradeById(id);
			if(grade==null)
				grade = new Integer(0);
			res.setContent(grade);
			res.setStatus(true);
		} else res.setError("查询成绩时出错");
		return res;
	}

	/**
	 * 获取还没有完成的任务信息
	 */
	@Override
	public ResponseForm getNotCompletedDataById(String id) {
		res = new ResponseForm();
		if (id != null && id.length() != 0) {
			List<Grade> dataList = gradeMapper.selNotCompletedDataById(id);
			res.setContent(dataList);
			res.setStatus(true);
		} else res.setError("查询数据时出错");
		return res;
	}

	/**
	 * 获取还没用批改的任务信息
	 */
	@Override
	public ResponseForm getNotApprovedDataById(String id) {
		res = new ResponseForm();
		if (id != null && id.length() != 0) {
			List<Grade> dataList = gradeMapper.selNotApprovedDataById(id);
			res.setContent(dataList);
			res.setStatus(true);
		} else res.setError("查询数据时出错");
		return res;
	}

	/**
	 * 获取已经完成了的信息
	 */
	@Override
	public ResponseForm getCompletedDataById(String id) {
		res = new ResponseForm();
		if (id != null && id.length() != 0) {
			List<Grade> dataList = gradeMapper.selCompletedDataById(id);
			//添加名字
			if(dataList!=null){
				for(Grade e:dataList){
					String name = userMapper.selUserById(e.getStuNum()).getName();
					e.setName(name);
				}
				res.setContent(dataList);
				res.setStatus(true);
			}
		} else res.setError("查询数据时出错");
		return res;
	}

	@Override
	public ResponseForm listScoreDetailByTaskId(String TaskId) {
		res = new ResponseForm();
		if (TaskId != null && TaskId != "") {
			List<Grade> dateList = gradeMapper.selScoreListByTaskId(TaskId);
			if (dateList != null) {
				for(Grade e:dateList){
					//设置姓名
					e.setName(userMapper.selUserById(e.getStuNum()).getName());
				}
				res.setStatus(true);
				res.setContent(dateList);
			} else res.setError("查询失败");
		} else res.setError("参数错误");
		return res;
	}

	/**
	 * 通过id和taskId获取详细信息
	 */
	@Override
	public ResponseForm getDataByIdAndTaskId(Grade e) {
		res = new ResponseForm();
		if (e.getStuNum() != null && e.getStuNum().length() != 0 && e.getTaskId() != null) {
			Grade grade = gradeMapper.selDataByIdAndTaskId(e);
			if(grade!=null){
				String name = userMapper.selUserById(grade.getStuNum()).getName();
				grade.setName(name);
				res.setContent(grade);
				res.setStatus(true);
			} else res.setError("查询数据时出错");
		} else res.setError("参数错误");
		return res;
	}

	/**
	 * 将未完成状态变成未批阅
	 *
	 * @return 一个int值，0代表失败
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResponseForm changeStatusFromNotCompletedToNotApproved(Grade e) {
		res = new ResponseForm();
		String time_submit = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		e.setTime_submit(time_submit);
		//这里对codeFileLink进行处理，没有进行空格处理
		if (e.getCodeFileLink() == null)
			e.setCodeFileLink("");
		//检测数据是否已存在
		if(gradeMapper.seluncorrentDataByIdAndTaskId(e)!=null){
			res.setError("数据已存在");
			return res;
		}
		int index = gradeMapper.insNewUnCorrentData(e);
		int result = 0;
		if (index != 0)
			result = gradeMapper.delUnSubmitDataById(e);
		if (result != 0) {
			res.setStatus(true);
			res.setContent(result);
		} else res.setError("更新用户状态失败");
		return res;
	}

	/**
	 * 将未批阅状态变成已完成
	 *
	 * @return 一个int值，0代表失败
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResponseForm changeStatusFromNotApprovedToCompleted(Grade e) {
		res = new ResponseForm();
		// 当前的时间戳
		String time_correct = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		e.setTime_correct(time_correct);
		//看数据是否已存在
		if(gradeMapper.selDataByIdAndTaskId(e)!=null){
			res.setError("数据已存在");
			return res;
		}
		int index = gradeMapper.insNewCompletedData(e);
		int result = 0;
		if (index != 0)
			result = gradeMapper.delUnCorrentDataById(e);
		if (result != 0) {
			res.setStatus(true);
			res.setContent(result);
		} else res.setError("更新用户状态失败");
		return res;
	}

	/**
	 * 对taskId进行验证
	 */
	@Override
	public ResponseForm checkTaskIdByStatus(Grade e, int status) {
		res = new ResponseForm();
		List<String> reList = null;
		//先利用status获取数据库中对应的值
		switch (status) {
			case 0:
				reList = gradeMapper.selUnSubmitTaskId(e.getStuNum());
				break;
			case 1:
				reList = gradeMapper.selUnCorrentTaskId(e.getStuNum());
				break;
			case 2:
				reList = gradeMapper.selCompletedTaskId(e.getStuNum());
				break;
			default:
				reList = new ArrayList<>();
		}
		int index = reList.indexOf(e.getTaskId());
		if (index == -1)
			res.setError("该taskId无效");
		else {
			res.setContent("taskId有效");
			res.setStatus(true);
		}
		return res;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResponseForm getTotalTopTen() {
		res = new ResponseForm();
		//创建一个数组存放数据
		ArrayList<Grade> list = new ArrayList<>();
		int count = 0;
		try {
			List<User> selAllEffectiveUser = userMapper.selAllEffectiveUser();
			Grade man = null;
			int i = 0;
			for (User e : selAllEffectiveUser) {
				//将所有人的总成绩都存放起来
				man = gradeMapper.selTotalScoreById(e.getStuNum());
				if(man!=null){
					man.setName(userMapper.selUserById(e.getStuNum()).getName());
					list.add(man);
				}
			}
			Collections.sort(list);
			//确定取出的个数
			count = 10 > list.size() ? list.size() : 10;
		} catch (Exception e) {
			res.setError(e.getMessage());
		}
		res.setStatus(true);
		res.setContent(list.subList(0, count));
		return res;
	}

	@Override
	public ResponseForm getGradeInfoByTaskId(String taskid) {
		return null;
	}

	@Override
	public ResponseForm addNewTask(Grade e) {
		return null;
	}

	@Override
	public ResponseForm getUncorrectInfo(Grade e) {
		res = new ResponseForm();
		List<Grade> grades = gradeMapper.selUnCorrentInfoByTaskIdAndStuNum(e);
		if(grades!=null){
			for(Grade item:grades){
				//添加任务名
				item.setTemp(taskMapper.selTaskByTaskId(item.getTaskId()).getTitle());
			}
			res.setContent(grades);
			res.setStatus(true);
		} else res.setError("查询错误");
		return res;
	}

	@Override
	public ResponseForm getCountOfFinshed() {
		res = new ResponseForm();
		int i = gradeMapper.selFinshedScoreNum();
		if(i!=0){
			res.setStatus(true);
			res.setContent(i);
		} else res.setContent("查询失败");
		return res;
	}

	@Override
	public ResponseForm getCountOfUnCorrect() {
		res = new ResponseForm();
		int i = gradeMapper.selUnCorrentScoreNum();
		if(i!=0){
			res.setStatus(true);
			res.setContent(i);
		} else res.setContent("查询失败");
		return res;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResponseForm repulseHomeWork(Grade e) {
		res = new ResponseForm();
		//找到已经完成的taskid以及stuNum
		//先新增一条未提交的信息
		int result = gradeMapper.insNewUnSubmitData(e);
		if(result!=0){
			//删除一条完成信息
			int i = gradeMapper.delCompletedDataById(e);
			if(i!=0){
				res.setContent("打回成功");
				res.setStatus(true);
			} else res.setError("失败");
		} else res.setError("插入新数据时失败");
		return res;
	}

	@Override
	public ResponseForm listFinished() {
		res = new ResponseForm();
		List<Grade> grades = gradeMapper.selAllGradeLogs();
		if(grades!=null){
			//装填name
			for(Grade e : grades){
				e.setName(userMapper.selUserById(e.getStuNum()).getName());
				e.setContent("");
				//使用temp字段添加任务标题
				e.setTemp(taskMapper.selTaskByTaskId(e.getTaskId()).getTitle());
			}
			res.setContent(grades);
			res.setStatus(true);
		} else res.setError("获取成绩信息失败");
		return res;
	}

	@Override
	public ResponseForm delFinishedBy(Grade e) {
		res = new ResponseForm();
		int i = gradeMapper.delCompletedDataById(e);
		if(i!=0){
			res.setStatus(true);
			res.setContent(i);
		} else res.setContent("删除失败");
		return res;
	}

	@Override
	public ResponseForm listUnSubmit() {
		res = new ResponseForm();
		List<Grade> grades = gradeMapper.selAllNotApprovedData();
		if(grades!=null){
			//添加相应信息
			for(Grade e:grades){
				//添加姓名
				e.setName(userMapper.selUserById(e.getStuNum()).getName());
				//添加任务名
				e.setTemp(taskMapper.selTaskByTaskId(e.getTaskId()).getTitle());
			}
			res.setContent(grades);
			res.setStatus(true);
		} else res.setError("查询错误");
		return res;
	}


}
