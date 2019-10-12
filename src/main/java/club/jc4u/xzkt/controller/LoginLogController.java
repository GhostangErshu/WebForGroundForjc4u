package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.LoginLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginLogController {
	@Autowired
	private LoginLogServiceImpl loginLogServiceImpl;

	@RequestMapping("/getLastLog")
	ResponseForm getLastLog(String id) {
		return loginLogServiceImpl.getLastLog(id);
	}

	@RequestMapping("/listLog")
	ResponseForm getAllLogById(String id) {
		return loginLogServiceImpl.getAllLogById(id);
	}

	@RequestMapping("/getNumOfLogin")
	ResponseForm getNumOfLogin(String id) {
		return loginLogServiceImpl.getNumOfLogin(id);
	}

}
