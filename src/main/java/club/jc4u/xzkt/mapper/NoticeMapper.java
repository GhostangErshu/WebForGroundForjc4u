package club.jc4u.xzkt.mapper;

import java.util.List;

import club.jc4u.xzkt.entity.Notice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface NoticeMapper {
	
	@Select("select * from t_notice")
	List<Notice> selAll();

	@Select("select * from t_notice where notice_id = #{id}")
	Notice selById(String id);

	//点击数+1
	@Update("UPDATE t_notice SET click = (click+1)")
	int updClickNum();

	//增加新的通知
	@Insert("insert into t_notice values(default,#{notice_id},#{title},#{publisher},#{time},0,#{content})")
	int insNewNotice(Notice e);
}
