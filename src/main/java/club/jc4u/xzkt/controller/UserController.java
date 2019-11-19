package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.User;
import club.jc4u.xzkt.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("/sendEmailForResetPwd")
	ResponseForm sendEmailForResetPwd(String username, HttpServletRequest request) {
		return userService.sendEmailForResetPwd(username, request);
	}

	@RequestMapping("/ResetPwd")
	ResponseForm resetPwd(HttpServletRequest req) {
		return userService.resetPwd(req);
	}

	@RequestMapping("/checkExist")
	ResponseForm checkUserExist(String username) {
		return userService.checkUserExist(username);
	}

	@RequestMapping("/getInfo")
	ResponseForm getUserInfoById(String id) {
		return userService.getUserInfoById(id);
	}

	@RequestMapping("/updatePwd")
	ResponseForm changeUserPwd(User old, String newPassword) {
		return userService.updateUserPwd(old, newPassword);
	}

	@RequestMapping("/updateSign")
	ResponseForm updateUserSignById(String sign, String username) {
		return userService.updateUserSign(username, sign);
	}


	@RequestMapping("/updateEmail")
	ResponseForm updateUserEmail(User user) {
		return userService.updateUserEmail(user);
	}

}
