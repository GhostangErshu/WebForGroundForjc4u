package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface UserMapper {
	/**
	 * 查询全部 
	 * @return
	 */
	@Select("SELECT * FROM t_users")
	List<User> selAll();
	
	/**
	 * 查找email
	 * @param username
	 * @return
	 */
	@Select("select email from t_users where stuNum = #{username}")
	String selUserEmail(String username);

	/**
	 * 查询用户是否存在
	 * @param username
	 * @return
	 */
	@Select("select COUNT(1) from t_users where stuNum = #{username}")
	int selUserExist(String username);
	
	/**
	 * 根据用户名和密码查询，用于登录验证
	 * @return
	 */
	@Select("SELECT * FROM t_users WHERE stuNum=#{stuNum} and password = #{password}")
	User selUserByNumAndPwd(User user);
	
	/**
	 * select user by id
	 * @param id
	 * @return user
	 */
	@Select("select * from t_users where stuNum=#{id}")
	User selUserById(String id);
	
	/**
	 * 这里的username代表用户名，也就是这里的stuNum
	 * @param username
	 * @param password
	 * @return
	 */
	@Update("update t_users set password = #{password} where stuNum = #{username}")
	int updUserPwd(@Param("username") String username, @Param("password") String password);
	
	/**
	 * 更新用户头像
	 * @param stuNum
	 * @param path
	 * @return
	 */
	@Update("update t_users set head = #{path} where stuNum = #{stuNum}")
	int updUserHead(@Param("stuNum") String stuNum, @Param("path") String path);
	
	/**
	 * 更新用户的签名
	 * @param username
	 * @param newSign
	 * @return 返回受影响的行数
	 */
	@Update("update t_users set sign = #{newSign} where stuNum = #{username}")
	int updUserSign(@Param("username") String username, @Param("newSign") String newSign);
	
	/**
	 * 查询现在的有效课程用户
	 * @return
	 */
	@Select("select * from t_users where status = 1")
	List<User> selAllEffectiveUser();
}
