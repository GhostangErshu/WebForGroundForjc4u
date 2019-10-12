package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.Resource;
import org.apache.ibatis.annotations.Select;


public interface SrcMapper {
	
	@Select("SELECT * FROM t_srcs")
	List<Resource> selAll();
}
