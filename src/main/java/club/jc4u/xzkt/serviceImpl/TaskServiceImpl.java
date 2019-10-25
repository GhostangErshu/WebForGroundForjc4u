package club.jc4u.xzkt.serviceImpl;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.Task;
import club.jc4u.xzkt.mapper.TaskMapper;
import club.jc4u.xzkt.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskMapper taskMapper;

	private ResponseForm res;

	@Override
	public ResponseForm getTaskDetailByTaskId(String taskId) {
		res = new ResponseForm();
		if (taskId != null) {
			Task task = taskMapper.selTaskByTaskId(taskId);
			if(task!=null){
				res.setStatus(true);
				res.setContent(task);
			} else res.setError("获取任务详细信息失败");
		}
		return res;
	}

	@Override
	public ResponseForm listTaskSimpleInfo() {
		res = new ResponseForm();

		List<Task> tasks = taskMapper.selAllTaskSimpleInfo();
		if(tasks!=null){
			res.setStatus(true);
			res.setContent(tasks);
		} else res.setError("获取任务简略信息失败");
		return res;
	}

}
