package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.User;
import org.apache.ibatis.annotations.*;


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
	@Select("SELECT * FROM t_users WHERE stuNum=#{stuNum} and password = #{password} and status = 0")
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

	@Update("update t_users set email = #{email} where stuNum = #{stuNum}")
	int updUserEmail(User user);

	//这里是管理员所属接口mapper
	/**
	 * 查询现在的有效用户
	 * @return
	 */
	@Select("select * from t_users where status = 0 and powerLevel = 1")
	List<User> selAllEffectiveUser();

	@Select("select * from t_users where status = 0 and powerLevel > 1")
	List<User> selAllAdminUser();

	//初始化不拥有邮箱以及签名头像
	@Insert("insert into t_users values(default,#{stuNum},#{name},#{password},0,'','','',1)")
	int insNewNormalUser(User user);

	@Insert("insert into t_users values(default,#{stuNum},#{name},#{password},0,'','','',#{powerLevel})")
	int insNewAdminUser(User user);

	@Delete("delete from t_users where stuNum = #{stuNum}")
	int delUser(User user);

	@Update("update t_users set status=#{status},email=#{email},sign=#{sign},powerLevel=#{powerLevel} where stuNum = #{stuNum}")
	int updUser(User user);

	//密码重置
	@Update("update t_users set password = #{password} where stuNum = #{stuNum}")
	int updUserPassword(User user);
}
