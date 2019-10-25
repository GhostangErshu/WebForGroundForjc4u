package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/task")
@RestController
public class TaskController {

	@Autowired
	private TaskServiceImpl taskService;

	@RequestMapping("/getDetailInfo")
	ResponseForm getTaskInfoByTaskId(String taskId){
		return taskService.getTaskDetailByTaskId(taskId);
	}

	@RequestMapping("/listSimpleInfo")
	ResponseForm listSimpleTaskInfo(){
		return taskService.listTaskSimpleInfo();
	}
}
