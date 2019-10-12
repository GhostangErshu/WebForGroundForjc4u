package club.jc4u.xzkt.mapper;

import club.jc4u.xzkt.entity.Suggestion;
import org.apache.ibatis.annotations.Insert;


public interface SuggestionMapper {

	@Insert("insert into t_suggestion values(default,#{name},#{content},#{time})")
	int insNewSuggestion(Suggestion e);
	
}
