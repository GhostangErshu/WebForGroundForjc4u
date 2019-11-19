package club.jc4u.xzkt.service;


import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
	
	/**
	 * 通过id获取用户信息
	 * @param id
	 * @return
	 */
	ResponseForm getUserInfoById(String id);

	ResponseForm updateUserPwd(User old,String newPassword) ;

	ResponseForm updateUserHeadImg(String username, String path);

	ResponseForm updateUserSign(String username, String newSign);

	ResponseForm updateUserEmail(User user);

	ResponseForm checkUserExist(String username);

	ResponseForm getEmailById(String id);

	ResponseForm sendEmailForResetPwd(String username, HttpServletRequest request);

	ResponseForm resetPwd(HttpServletRequest req);

	ResponseForm getActivePersonNum();

	ResponseForm listActivePerson();

	ResponseForm listAdminPerson();

	ResponseForm modifyUserInfo(User user);

	ResponseForm modifyAdminInfo(User user);

	ResponseForm addNormalUser(User user);

	ResponseForm addAdminUser(User user);

	ResponseForm delNormalUser(User user);

	ResponseForm delAdminUser(User user);

	ResponseForm resetPwd(User user);
}
