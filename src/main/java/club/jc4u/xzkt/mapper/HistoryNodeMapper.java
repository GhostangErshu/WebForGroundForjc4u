package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.HistoryNode;
import org.apache.ibatis.annotations.Select;


public interface HistoryNodeMapper {
	
	@Select("select * from t_history")
	List<HistoryNode>selAll();
}
