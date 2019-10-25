package club.jc4u.xzkt.service;


import club.jc4u.xzkt.entity.ResponseForm;

public interface TaskService {

	ResponseForm getTaskDetailByTaskId(String taskId);

	ResponseForm listTaskSimpleInfo();
}
