package club.jc4u.xzkt.serviceImpl;

import club.jc4u.xzkt.entity.Grade;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.Task;
import club.jc4u.xzkt.mapper.GradeMapper;
import club.jc4u.xzkt.mapper.TaskMapper;
import club.jc4u.xzkt.service.TaskService;
import club.jc4u.xzkt.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Transactional
@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private GradeMapper gradeMapper;

	private ResponseForm res;

	@Override
	public ResponseForm getTaskDetailByTaskId(String taskId) {
		res = new ResponseForm();
		if (taskId != null) {
			Task task = taskMapper.selTaskByTaskId(taskId);
			if (task != null) {
				res.setStatus(true);
				res.setContent(task);
			} else res.setError("获取任务详细信息失败");
		}
		return res;
	}

	@Override
	public ResponseForm listTaskSimpleInfo(String id) {
		res = new ResponseForm();
//		方案1，使用classid获取
//		List<Task> tasks = taskMapper.selAllTaskSimpleInfo(id);
//		方案2，获取全部
		List<Task> tasks = taskMapper.listTaskSimpleInfo();
		if (tasks != null) {
			res.setStatus(true);
			res.setContent(tasks);
		} else res.setError("获取任务简略信息失败");
		return res;
	}

	/**
	 * 作业发布，涉及到三个持久层的类
	 * @param task
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResponseForm addNewTask(Task task) {
		res = new ResponseForm();
		//先处理一下元数据
		//随机生成taskId
		String taskId = MD5Util.getMD5(UUID.randomUUID().toString());
		task.setTaskId(taskId);
		//先备份了数据信息
		int result = taskMapper.insNewTask(task);
		if (result != 0) {
			//再来插入到发布作业
			List<String> stuNums = taskMapper.selAllStuNumByClassId(""+task.getClassId());
			if (stuNums != null) {
				Grade e = new Grade();
				for(String id:stuNums){
					e.setStuNum(id);
					e.setTaskId(task.getTaskId());
					//检查成绩是否存在
					if(gradeMapper.selunsubmitDataByIdAndTaskId(e)!=null){
						res.setError("数据已存在");
						return res;
					}
					int i = gradeMapper.insNewUnSubmitData(e);
					if(i!=0){
						res.setContent("增加成功");
						res.setStatus(true);
					} else res.setError(id+"发布失败");
				}
			}
			res.setStatus(true);
			res.setContent("增加成功");
		} else res.setError("增加失败");
		return res;
	}

	//查询有哪些作业
	public ResponseForm listAllTaskInfoByClassId(String classId){
		res = new ResponseForm();
		List<Task> tasks = taskMapper.selAllTaskSimpleInfoByClassId(classId);
		//再查看是否有未批阅的
		if(tasks!=null){
			for(int i=0;i<tasks.size();i++){
				int result = gradeMapper.selUnCorrentInfoNumByTaskIdAndStuNum(tasks.get(i).getTaskId());
				//当没有未批阅的时候
				if(result==0){
					tasks.remove(i);
				}
			}
			res.setContent(tasks);
			res.setStatus(true);
		} else res.setError("查询失败");
		return res;
	}
}
