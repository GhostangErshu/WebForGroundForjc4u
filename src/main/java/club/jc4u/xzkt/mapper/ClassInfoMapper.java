package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.ClassInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface ClassInfoMapper {
	
	@Select("select * from t_class where id = (SELECT classId FROM `t_chooseclass` where stuNum = #{id}  ORDER BY id DESC LIMIT 1);")
	ClassInfo selLastClassInfoById(String id);
	
	@Select("select * from t_class where id  in (SELECT classId FROM t_chooseclass where stuNum = #{id} );")
	List<ClassInfo> selAllClassInfoById(String id);
	
	@Select("select name from t_class where id = #{id}")
	String selClassNameById(int id);

	@Select("select * from t_class")
	List<ClassInfo> selAllClassInfo();

	//正常状态的班级
	@Select("select * from t_class where status = 1")
	List<ClassInfo> selAllActiveClassInfo();

	@Update("update t_class set status = #{status} where id = #{id}")
	int updClassStatus(ClassInfo e);

	@Insert("insert into t_class values(default,#{name},#{teacher},#{semester},#{length},0)")
	int insNewInfo(ClassInfo e);


}
