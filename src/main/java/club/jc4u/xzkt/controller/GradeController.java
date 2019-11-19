package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.Grade;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.GradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "/grade")
@RestController
public class GradeController {
	@Autowired
	private GradeServiceImpl gradeService;

	//获取单个成绩
	@RequestMapping("/getSimple")
	ResponseForm getScoreById(String id) {
		return gradeService.getGradeById(id);
	}

	//获取成绩细节
	@RequestMapping("/getDetail")
	ResponseForm getScoreDetailsById(String id) {
		return gradeService.getCompletedDataById(id);
	}

	//通过taskid获取完成的信息
	@RequestMapping("/listDetail")
	ResponseForm listScoreDetailByTaskId(String TaskId) {
		return gradeService.listScoreDetailByTaskId(TaskId);
	}

	//获取未批改任务
	@RequestMapping("/getNotCompleted")
	ResponseForm getNotCompletedDataById(String id) {
		return gradeService.getNotCompletedDataById(id);
	}

	//获取已完成任务
	@RequestMapping("/getCompleted")
	ResponseForm getCompletedDataById(String id) {
		return gradeService.getCompletedDataById(id);
	}

	//获取已完成任务
	@RequestMapping("/getSimpleCompleted")
	ResponseForm getCompletedDataByIdAndTaskId(Grade e) {
		return gradeService.getDataByIdAndTaskId(e);
	}

	//获取未完成任务
	@RequestMapping("/getNotApproved")
	ResponseForm getNotApprovedDataById(String id) {
		return gradeService.getNotApprovedDataById(id);
	}

	//通过taskId和ID获取数据
	@RequestMapping("/getDataByIdAndTaskId")
	ResponseForm getDataByIdAndTaskId(Grade e) {
		return gradeService.getDataByIdAndTaskId(e);
	}

	@RequestMapping("/commitTask")
	ResponseForm commitTask(Grade grade) {
		return gradeService.changeStatusFromNotCompletedToNotApproved(grade);
	}

	@RequestMapping("/checkTaskIdByStatus")
	ResponseForm checkTaskIdByStatus(Grade grade, int status) {
		return gradeService.checkTaskIdByStatus(grade, status);
	}

	@RequestMapping("/getTopTen")
	ResponseForm getTopTenScore() {
		return gradeService.getTotalTopTen();
	}

	@RequestMapping("/listAllUnSubmit")
	ResponseForm listAllUnSubmit(){return gradeService.listUnSubmit();}
}
