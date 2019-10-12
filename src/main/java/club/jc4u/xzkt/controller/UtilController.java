package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.UtilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/historyEvent")
public class UtilController {
	
	@Autowired
	private UtilServiceImpl utilService;
	
	@RequestMapping("/getInfo")
	ResponseForm getHistoryEvents(String month, String day){
		return utilService.getHistoryEvents(month,day);
	}
}
