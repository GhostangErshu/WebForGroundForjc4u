package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.Countdown;
import org.apache.ibatis.annotations.Select;


public interface CountDownMapper {
	
	@Select("select * from t_countdown")
	List<Countdown> selAll();
}
