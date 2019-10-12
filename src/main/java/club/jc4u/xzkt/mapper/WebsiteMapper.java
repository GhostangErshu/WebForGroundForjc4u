package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.Website;
import org.apache.ibatis.annotations.Select;


public interface WebsiteMapper {
	
	@Select("select * from t_website")
	List<Website> selAllInfo();
}
