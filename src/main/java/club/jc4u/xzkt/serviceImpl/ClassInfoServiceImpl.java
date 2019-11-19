package club.jc4u.xzkt.serviceImpl;

import java.util.List;

import club.jc4u.xzkt.entity.ClassInfo;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.Semester;
import club.jc4u.xzkt.mapper.ClassInfoMapper;
import club.jc4u.xzkt.mapper.SemesterMapper;
import club.jc4u.xzkt.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClassInfoServiceImpl implements ClassInfoService {

	@Autowired
	private ClassInfoMapper classInfoMapper;
	@Autowired
	private SemesterMapper semesterMapper;

	private ResponseForm res;
	
	//获取用户现在的班级信息
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResponseForm getUserRealtimeClassInfoById(String id) {
		res = new ResponseForm();
		//先获取数据库中class表的信息
		ClassInfo temp = classInfoMapper.selLastClassInfoById(id);
		//再获取semester表中的学习信息
		Semester semester = semesterMapper.selInfoByNickname(temp.getSemester());
		//使用日期值覆盖以前的semester
		if(semester!=null&&temp!=null){
			temp.setSemester(semester.getSemester_time());
			res.setStatus(true);
			res.setContent(temp);
		} else res.setError("获取班级信息失败");
		return res;
	}

	//获取用户所有历史班级信息
	@Override
	public ResponseForm getUserAllClassInfoById(String id) {
		res = new ResponseForm();
		List<ClassInfo> classInfos = classInfoMapper.selAllClassInfoById(id);
		if(classInfos!=null){
			res.setStatus(true);
			res.setContent(classInfos);
		} else res.setError("查询失败");
		return res;
	}

	@Override
	public ResponseForm getAllClassInfo() {
		res = new ResponseForm();
		List<ClassInfo> classInfos = classInfoMapper.selAllClassInfo();
		if(classInfos!=null){
			res.setStatus(true);
			res.setContent(classInfos);
		} else res.setError("查询失败");
		return res;
	}

	@Override
	public ResponseForm updateClassStatus(ClassInfo e) {
		res = new ResponseForm();
		int i = classInfoMapper.updClassStatus(e);
		if(i!=0){
			res.setStatus(true);
			res.setContent("更新成功");
		} else res.setError("查询失败");
		return res;
	}

	@Override
	public ResponseForm addNewClass(ClassInfo e) {
		res = new ResponseForm();
		int i = classInfoMapper.insNewInfo(e);
		if(i!=0){
			res.setStatus(true);
			res.setContent("插入成功");
		} else res.setError("查询失败");
		return res;
	}

	@Override
	public ResponseForm getAllActiveClass() {
		res = new ResponseForm();
		List<ClassInfo> classInfos = classInfoMapper.selAllActiveClassInfo();
		if(classInfos!=null){
			res.setStatus(true);
			res.setContent(classInfos);
		} else res.setError("查询失败");
		return res;
	}

}
