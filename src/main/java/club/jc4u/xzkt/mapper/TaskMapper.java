package club.jc4u.xzkt.mapper;

import club.jc4u.xzkt.entity.Task;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface TaskMapper {
	
	@Select("select * from t_task where taskId = #{taskId}")
	Task selTaskByTaskId(String taskId);

	@Select("select title,taskId from t_task")
	List<Task> selAllTaskSimpleInfo();
}
