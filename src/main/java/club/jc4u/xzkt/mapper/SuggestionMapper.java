package club.jc4u.xzkt.mapper;

import club.jc4u.xzkt.entity.Grade;
import club.jc4u.xzkt.entity.Suggestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface SuggestionMapper {

	@Insert("insert into t_suggestion values(default,#{name},#{content},#{time})")
	int insNewSuggestion(Suggestion e);

}
