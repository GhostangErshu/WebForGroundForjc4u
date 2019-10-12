package club.jc4u.xzkt.mapper;

import club.jc4u.xzkt.entity.Semester;
import org.apache.ibatis.annotations.Select;


public interface SemesterMapper {
	
	@Select("select * from t_semester where semester_nickname = #{nickname}")
	Semester selInfoByNickname(String nickname);
}
