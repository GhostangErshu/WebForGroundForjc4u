package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.HistoryNodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
public class HistoryNodeController {
	@Autowired
	private HistoryNodeServiceImpl historyNodeService;
	
	@RequestMapping("/listNodeInfo")
	ResponseForm getAllHistoryNodeInfo(){
		return historyNodeService.getAllNode();
	}
	
}
