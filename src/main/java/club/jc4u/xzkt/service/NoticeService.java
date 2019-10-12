package club.jc4u.xzkt.service;

import club.jc4u.xzkt.entity.ResponseForm;


public interface NoticeService {
	
	ResponseForm getAllNotices();

	ResponseForm getOneNotice(String id);

	ResponseForm increaseNoticeClickNum();
}