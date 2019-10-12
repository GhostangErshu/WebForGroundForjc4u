package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.Video;
import org.apache.ibatis.annotations.Select;


public interface VideoMapper {
	
	@Select("select * from t_video")
	List<Video> selAll();

	@Select("select * from t_video where video_id = #{id}")
	Video selInfo(String id);
}
