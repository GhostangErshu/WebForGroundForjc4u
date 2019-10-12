package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.Carousel;
import org.apache.ibatis.annotations.Select;


public interface CarouselMapper {
	@Select("select * from t_carousel")
	List<Carousel> selAllInfo();
}
