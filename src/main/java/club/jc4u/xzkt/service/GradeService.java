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

	//获取完成的数据
	ResponseForm listScoreDetailByTaskId(String TaskId);

	//通过id和taskId获取Task信息
	ResponseForm getDataByIdAndTaskId(Grade grade);

	//提交后改变用户状态
	ResponseForm changeStatusFromNotCompletedToNotApproved(Grade e);

	//批改后改变用户状态
	ResponseForm changeStatusFromNotApprovedToCompleted(Grade e);

	//通过状态核查TaskId
	ResponseForm checkTaskIdByStatus(Grade e, int status);

	//获取前十名
	ResponseForm getTotalTopTen();

	//通过TaskId获取成绩信息
	ResponseForm getGradeInfoByTaskId(String taskId);

	//发布作业
	ResponseForm addNewTask(Grade e);

	//获取待批阅的作业信息
	ResponseForm getUncorrectInfo(Grade e);

	ResponseForm getCountOfFinshed();

	ResponseForm getCountOfUnCorrect();

	//作业打回
	ResponseForm repulseHomeWork(Grade e);

	//列出全部成绩信息
	ResponseForm listFinished();

	ResponseForm delFinishedBy(Grade e);

	ResponseForm listUnSubmit();
}	
