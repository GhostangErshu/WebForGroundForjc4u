package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.Resource;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface SrcMapper {
	
	@Select("SELECT * FROM t_srcs")
	List<Resource> selAll();

	@Select("select * from t_srcs where src_id = #{id}")
	Resource selOneById(String id);

	@Update("update t_srcs set visitNum = (visitNum+1) where src_id = #{id}")
	int updVisitNum(String id);
}
