package club.jc4u.xzkt.serviceImpl;

import club.jc4u.xzkt.entity.Notice;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.mapper.NoticeMapper;
import club.jc4u.xzkt.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;

	private ResponseForm res;

	@Override
	public ResponseForm getAllNotices() {
		res = new ResponseForm();
		List<Notice> notices = noticeMapper.selAll();
		if(notices!=null){
			res.setStatus(true);
			res.setContent(notices);
		} else res.setError("查询失败");
		return res;
	}

	@Override
	public ResponseForm getOneNotice(String id) {
		res = new ResponseForm();
		Notice notice = noticeMapper.selById(id);
		if(notice!=null){
			res.setStatus(true);
			res.setContent(notice);
		} else res.setError("查询失败");
		return res;
	}

	@Override
	public ResponseForm increaseNoticeClickNum() {
		res = new ResponseForm();
		int result = noticeMapper.updClickNum();
		if(result==1){
			res.setContent(result);
			res.setStatus(true);
		} else res.setError("增加失败");
		return res;
	}


}
