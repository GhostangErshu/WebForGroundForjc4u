package club.jc4u.xzkt.service;


import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationService {

	//登录接口
	ResponseForm login(User user, HttpServletRequest request);

	ResponseForm checkToken(String token);
}
