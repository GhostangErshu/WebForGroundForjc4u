package club.jc4u.xzkt.serviceImpl;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.User;
import club.jc4u.xzkt.mail.SendEmail;
import club.jc4u.xzkt.mapper.UserMapper;
import club.jc4u.xzkt.service.UserService;
import club.jc4u.xzkt.utils.MD5Util;
import club.jc4u.xzkt.utils.MathUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	private ResponseForm res;

	/**
	 * 通过id获取用户信息
	 */
	@Override
	public ResponseForm getUserInfoById(String id) {
		res = new ResponseForm();
		//在这里删除密码
		if(id!=null){
			User e = userMapper.selUserById(id);
			if(e!=null){
				res.setStatus(true);
				e.setPassword("这是不能看的哦");
				res.setContent(e);
			} else res.setError("查询信息失败");
		} else res.setError("参数错误");
		return res;
	}

	/**
	 * 用户更改密码
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResponseForm updateUserPwd(User old,String newPassword) {
		res = new ResponseForm();
		if(old!=null&&newPassword!=null){
			//检查是否有此用户
			if(userMapper.selUserByNumAndPwd(old)!=null) {
				if (userMapper.updUserPwd(old.getStuNum(), newPassword) != 0) {
					res.setContent("Success");
					res.setStatus(true);
				} else res.setError("更改密码失败");
			} else res.setError("用户名或密码错误");
		} else res.setError("参数有误");
		return res;
	}

	//更改头像
	@Override
	public ResponseForm updateUserHeadImg(String username, String path) {
		res = new ResponseForm();
		if(username!=null&&path!=null){
			int result = userMapper.updUserHead(username, path);
			if(result!=0){
				res.setStatus(true);
				res.setContent("更新成功");
			} else res.setError("更新失败，请稍后重试");
		} else res.setError("参数有误");
		return res;
	}

	/**
	 * 检查是否存在该用户
	 *
	 * @return 返回1代表有该用户 返回0代表用户不存在
	 */
	@Override
	public ResponseForm checkUserExist(String username) {
		res = new ResponseForm();
		if(username!=null){
			int i = userMapper.selUserExist(username);
			if(i==1){
				res.setStatus(true);
				res.setContent("有此用户");
			} else res.setError("查无此人");
		} else res.setError("参数错误");
		return  res;
	}

	/**
	 * 痛过用户名查找Email
	 */
	@Override
	public ResponseForm getEmailById(String id) {
		res = new ResponseForm();
		String email = userMapper.selUserEmail(id);
		if(email!=null){
			res.setStatus(true);
			res.setContent(email);
		} else res.setError("没有该用户或该用户未设置邮箱");
		return res;
	}

	@Override
	public ResponseForm sendEmailForResetPwd(String username, HttpServletRequest request) {
		res = new ResponseForm();
		String email = userMapper.selUserEmail(username);
		String code = MathUtil.getRandomNums(4);
		//发送邮件
		try {
			new SendEmail(email, code).send();
		} catch (Exception e) {
			// 发邮件出错
			res.setError(e.getMessage());
		}
		//将验证码放在服务器，用户二次验证
		request.getServletContext().setAttribute("emailCode", code);
		//这里返回刚刚发送验证码的时间
		res.setContent(new Date().getTime());
		res.setStatus(true);
		return res;
	}

	@Override
	public ResponseForm resetPwd(HttpServletRequest req) {
		res = new ResponseForm();
		String username = req.getParameter("username");
		//得到验证码
		String code = (String) req.getServletContext().getAttribute("emailCode");
		String time = (String) req.getParameter("time");
		int now = Integer.parseInt((new Date().getTime()+"").substring(5,9));
		int ago = Integer.parseInt(time.substring(5,9));
		if(now-ago<=6) {
			//得到用户传过来的验证码
			String codeInput = req.getParameter("code");
			if (codeInput != null) {
				//把密码重置为default
				if (codeInput.equals(code)) {
					//将上一次的验证码抹去
					req.getServletContext().removeAttribute("emailCode");
					//重置密码
					userMapper.updUserPwd(username, MD5Util.getMD5("default"));
					res.setContent("重置成功,现在密码为‘default’");
					res.setStatus(true);
				} else res.setError("验证码错误");
			} else res.setError("输入的验证码为空");
		} else res.setError("验证码超时");
		return res;
	}

	/**
	 * 更新用户签名
	 */
	@Override
	public ResponseForm updateUserSign(String username, String newSign) {
		res = new ResponseForm();
		if(username!=null&&newSign!=null){
			int i = userMapper.updUserSign(username, newSign);
			if(i!=0){
				res.setStatus(true);
				res.setContent("更新成功");
			} else res.setError("更新失败");
		} else res.setError("参数错误");
		return res;
	}
}
