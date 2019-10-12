package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.ClassInfo;
import org.apache.ibatis.annotations.Select;


public interface ClassInfoMapper {
	
	@Select("select * from t_class where id = (SELECT classId FROM `t_chooseclass` where stuNum = #{id}  ORDER BY id DESC LIMIT 1);")
	ClassInfo selLastClassInfoById(String id);
	
	@Select("select * from t_class where id  in (SELECT classId FROM t_chooseclass where stuNum = #{id} );")
	List<ClassInfo> selAllClassInfoById(String id);
	
	@Select("select name from t_class where id = #{id}")
	String selClassNameById(int id);
}
