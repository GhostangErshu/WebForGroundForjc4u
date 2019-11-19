package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.User;
import club.jc4u.xzkt.serviceImpl.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/verify",method = RequestMethod.POST)
@RestController
public class AuthenticationController {
	@Autowired
	private AuthenticationServiceImpl authenticationService;

	@RequestMapping("/login")
	public ResponseForm login(User user, HttpServletRequest request) {
		return authenticationService.login(user,request);
	}

	@RequestMapping("/adminLogin")
	public ResponseForm adminLogin(User user, HttpServletRequest request) {
		return authenticationService.adminLogin(user,request);
	}

	@RequestMapping("/checkToken")
	public ResponseForm checkToken(String token){
		return authenticationService.checkToken(token);
	}
}
