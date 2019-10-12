package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.LoginLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface LoginLogMapper {
	
	@Select("select * from t_loginlog where user_id = #{id}")
	List<LoginLog> selAllById(String userId);
	
	@Select("select * from t_loginlog")
	List<LoginLog> selAll();
	
	@Select("SELECT * FROM t_loginlog WHERE user_id = #{userId} ORDER BY id DESC LIMIT 1")
	LoginLog selLastLogByUserId(String userId);
	
	@Select("select COUNT(*) from t_loginlog where user_id = #{userId}")
	int selCountById(String userId);
	
	@Insert("insert into t_loginlog values(default,#{user_id},#{name},#{time},#{ip},#{location})")
	int insNewLog(LoginLog log);
}
