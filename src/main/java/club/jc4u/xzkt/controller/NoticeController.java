package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.Notice;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeServiceImpl noticeService;
	
	@RequestMapping("/listInfo")
	ResponseForm getAllNoticeInfo(){
		return noticeService.getAllNotices();
	}

	@RequestMapping("/getInfo" )
	ResponseForm getAllNoticeInfoById(String id){
		return noticeService.getOneNotice(id);
	}

	@RequestMapping("/click" )
	ResponseForm increaseNoticeClickNum(){
		return noticeService.increaseNoticeClickNum();
	}

	@RequestMapping("/add")
	ResponseForm addNewNotice(Notice notice){return  noticeService.addNewNotice(notice);};
}
