package club.jc4u.xzkt.service;


import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.Task;

public interface TaskService {

	ResponseForm getTaskDetailByTaskId(String taskId);

	ResponseForm listTaskSimpleInfo(String id);

	ResponseForm addNewTask(Task task);

	ResponseForm listAllTaskInfoByClassId(String classId);
}
