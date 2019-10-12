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

	@RequestMapping("/getSimple")
	ResponseForm getScoreById(String id) {
		return gradeService.getGradeById(id);
	}

	/**
	 * get details should check token status
	 *
	 * @param id
	 * @return If token is valid return details else return null
	 */
	@RequestMapping(value = "/getDetail")
	ResponseForm getScoreDetailsById(String id) {
		return gradeService.getCompletedDataById(id);
	}

	/**
	 * 获取未完成的任务信息
	 *
	 * @param id
	 * @return 未完成的任务集合
	 */
	@RequestMapping("/getNotCompleted")
	ResponseForm getNotCompletedDataById(String id) {
		return gradeService.getNotCompletedDataById(id);
	}

	/**
	 * 获取已经完成的任务信息
	 *
	 * @param id
	 * @return 已完成的任务集合
	 */
	@RequestMapping("/getCompleted")
	ResponseForm getCompletedDataById(String id) {
		return gradeService.getCompletedDataById(id);
	}

	/**
	 * 获取未批改的任务信息
	 *
	 * @param id
	 * @return 未批改的的任务集合
	 */
	@RequestMapping("/getNotApproved")
	ResponseForm getNotApprovedDataById(String id) {
		return gradeService.getNotApprovedDataById(id);
	}

	/**
	 * 通过id和taskId来获取数据
	 *
	 * @param id,taskId
	 * @return Grade
	 */
	@RequestMapping("/getDataByIdAndTaskId")
	ResponseForm getDataByIdAndTaskId(String id, String taskId) {
		return gradeService.getDataByIdAndTaskId(id, taskId);
	}

	@RequestMapping("/commitTask")
	ResponseForm commitTask(Grade grade) {
		return gradeService.changeStatusFromNotCompletedToNotApproved(grade);
	}

	@RequestMapping("/checkTaskIdByStatus")
	ResponseForm checkTaskIdByStatus(String status, String taskId) {
		return gradeService.checkTaskIdByStatus(status, taskId);
	}

	@RequestMapping("/getTopTen")
	ResponseForm getTopTenScore() {
		return gradeService.getTotalTopTen();
	}

}
