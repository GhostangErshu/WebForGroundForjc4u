package club.jc4u.xzkt.service;

import club.jc4u.xzkt.entity.Grade;
import club.jc4u.xzkt.entity.ResponseForm;

import java.util.List;


public interface GradeService {

	//通过id查询成绩
	ResponseForm getGradeById(String id);

	//获取未完成的数据
	ResponseForm getNotCompletedDataById(String id);

	//获取已经提交的数据
	ResponseForm getNotApprovedDataById(String id);

	//获取完成的数据
	ResponseForm getCompletedDataById(String id);

	//通过id和taskId获取Task信息
	ResponseForm getDataByIdAndTaskId(String id, String taskId);

	//提交后改变用户状态
	ResponseForm changeStatusFromNotCompletedToNotApproved(Grade e);

	//批改后改变用户状态
	ResponseForm changeStatusFromNotApprovedToCompleted(Grade e);

	//通过状态核查TaskId
	ResponseForm checkTaskIdByStatus(String status, String taskId);

	//获取前十名
	ResponseForm getTotalTopTen();

	//通过TaskId获取成绩信息
	ResponseForm getGradeInfoByTaskId(String taskId);
}	
