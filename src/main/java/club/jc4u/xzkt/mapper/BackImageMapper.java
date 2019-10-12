package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.BackgroundImg;
import org.apache.ibatis.annotations.Select;


public interface BackImageMapper {
	
	@Select("select * from t_backImg")
	List<BackgroundImg> selAll();
}
