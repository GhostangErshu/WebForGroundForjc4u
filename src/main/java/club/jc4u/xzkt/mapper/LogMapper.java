package club.jc4u.xzkt.mapper;

import club.jc4u.xzkt.entity.Log;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author TangXi
 * @Date 19-11-19 下午2:05
 */
public interface LogMapper {

	@Select("select * from t_log")
	List<Log> listAllLog();

	@Insert("insert into t_log values(DEFAULT,#{person},#{time},#{content})")
	int addLog(Log log);

	//删除指定时间之前的日志
	@Delete("delete from t_log where time < #{time}")
	int delLog(Log log);
}
