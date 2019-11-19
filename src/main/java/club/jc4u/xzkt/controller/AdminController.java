package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.*;
import club.jc4u.xzkt.serviceImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author TangXi
 * @Date 19-10-28 下午6:35
 */
@RequestMapping("/admin")
@RestController
public class AdminController {
	@Autowired
	private ClassInfoServiceImpl classInfoService;
	@Autowired
	private TaskServiceImpl taskService;
	@Autowired
	private GradeServiceImpl gradeService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private LoginLogServiceImpl loginlogService;
	@Autowired
	private LogServiceImpl logService;

	@RequestMapping("/class/listInfo")
	ResponseForm getAllClassInfo(){
		return classInfoService.getAllClassInfo();
	}

	@RequestMapping("/class/listActiveInfo")
	ResponseForm getAllActiveClassInfo(){
		return classInfoService.getAllActiveClass();
	}

	@RequestMapping("/task/addNew")
	ResponseForm addNewTask(Task task){
		return taskService.addNewTask(task);
	}

	@RequestMapping("/task/getInfo")
	ResponseForm getSimpleTaskInfo(String classId){
		return taskService.listAllTaskInfoByClassId(classId);
	}

	@RequestMapping("/grade/getUncorrect")
	ResponseForm getUncorrectInfo(Grade grade){
		return gradeService.getUncorrectInfo(grade);
	}

	@RequestMapping("/grade/addFinishOne")
	ResponseForm addFishedOne(Grade e){
		return gradeService.changeStatusFromNotApprovedToCompleted(e);
	}

	@RequestMapping("/grade/getFinishCount")
	ResponseForm getTotalCountOfFinsh(){
		return gradeService.getCountOfFinshed();
	}

	@RequestMapping("/grade/getUnCorrectCount")
	ResponseForm getCountOfUnCorrect(){
		return gradeService.getCountOfUnCorrect();
	}

	@RequestMapping("/grade/listFinished")
	ResponseForm listFinished(){
		return gradeService.listFinished();
	}

	@RequestMapping("/grade/delete")
	ResponseForm delFinishedBy(Grade e){
		return gradeService.delFinishedBy(e);
	}

	@RequestMapping(value = "/grade/repulseHomeWork",method = RequestMethod.POST)
	ResponseForm repulseHomework(Grade e){return gradeService.repulseHomeWork(e);}

	@RequestMapping("/user/getNums")
	ResponseForm getActivePersons(){
		return userService.getActivePersonNum();
	}

	@RequestMapping("/loginLog/del")
	ResponseForm delLog(LoginLog log){return loginlogService.delLog(log);}

	/******************************************************************************/

	@RequestMapping("/user/listInfo")
	ResponseForm listActivePerson(){return userService.listActivePerson();}

	@RequestMapping("/user/add")
	ResponseForm addNormalUser(User user){return userService.addNormalUser(user);}

	@RequestMapping("/user/delete")
	ResponseForm delNormalUser(User user){return userService.delNormalUser(user);}

	@RequestMapping("/user/resetPwd")
	ResponseForm resetUserPwd(User user){return userService.resetPwd(user);}

	@RequestMapping("/super/listInfo")
	ResponseForm delLog(User user){return userService.listAdminPerson();}

	@RequestMapping("/super/add")
	ResponseForm addAdminUser(User user){return userService.addAdminUser(user);}

	@RequestMapping("/super/delete")
	ResponseForm delAdminUser(User user){return userService.delAdminUser(user);}

	@RequestMapping("/super/update")
	ResponseForm modifyUserInfo(User user){return userService.modifyUserInfo(user);}

	@RequestMapping("/log/del")
	ResponseForm delLog(Log log){return logService.del(log);}

	@RequestMapping("/log/list")
	ResponseForm listLog(){return logService.list();}

	@RequestMapping("/log/add")
	ResponseForm addLog(Log log){return logService.add(log);}
}