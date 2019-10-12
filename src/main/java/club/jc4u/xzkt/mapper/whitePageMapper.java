package club.jc4u.xzkt.mapper;

import club.jc4u.xzkt.entity.WhitePage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author TangXi
 * @Date 19-9-24 下午4:34
 */
public interface whitePageMapper {

	@Select("select * from t_whitePage")
	List<WhitePage> selALL();
}
