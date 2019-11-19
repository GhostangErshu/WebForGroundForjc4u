package club.jc4u.xzkt.serviceImpl;

import club.jc4u.xzkt.entity.Notice;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.mapper.NoticeMapper;
import club.jc4u.xzkt.service.NoticeService;
import club.jc4u.xzkt.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


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

	@Override
	public ResponseForm addNewNotice(Notice notice) {
		res = new ResponseForm();
		//进行时间的增加
		String time = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		notice.setTime(time);
		//进行随机noticeId的增加
		notice.setNotice_id(MD5Util.getMD5(UUID.randomUUID().toString()));
		int index = noticeMapper.insNewNotice(notice);
		if(index!=0){
			res.setContent("增加成功");
			res.setStatus(true);
		} else res.setError("增加失败");
		return res;
	}


}
