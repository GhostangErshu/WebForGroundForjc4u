package club.jc4u.xzkt.mapper;

import club.jc4u.xzkt.entity.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface TaskMapper {
	
	@Select("select * from t_task where taskId = #{taskId}")
	Task selTaskByTaskId(String taskId);

	@Select("select title,taskId from t_task where classid in (select classid from t_chooseclass where stuNum = #{id})")
	List<Task> selAllTaskSimpleInfo(String id);

	@Select("select title,taskId from t_task where classId = #{id}")
	List<Task> selAllTaskSimpleInfoByClassId(String id);

	@Select("select title,taskId from t_task ")
	List<Task> listTaskSimpleInfo();

	@Insert("insert into t_task values(default,#{title},#{publisher},#{deadline},#{notes},#{fileLink},#{taskId},#{classId})")
	int insNewTask(Task e);

	@Select("select stuNum from t_chooseclass where classId = #{id}")
	List<String> selAllStuNumByClassId(String id);
}
