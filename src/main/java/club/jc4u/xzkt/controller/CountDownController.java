package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.CountDownServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/countdown",method = RequestMethod.GET)
public class CountDownController {

	@Autowired
	private CountDownServiceImpl countDownService;

	@RequestMapping("/getMostRecent")
	@ResponseBody
	ResponseForm getMostRecentThing() {
		return countDownService.getMostRecentThing();
	}
}
