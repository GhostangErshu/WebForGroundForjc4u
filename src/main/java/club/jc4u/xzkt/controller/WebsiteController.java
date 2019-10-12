package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.WebServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/website",method = RequestMethod.GET)
@RestController
public class WebsiteController {
	@Autowired
	private WebServiceImpl webService;
	
	@RequestMapping("/listInfo")
	ResponseForm getAllWebsiteInfo(){
		return webService.getAllWebsiteInfo();
	}
}
