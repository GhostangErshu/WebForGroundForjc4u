package club.jc4u.xzkt.serviceImpl;


import club.jc4u.xzkt.entity.LoginLog;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.User;
import club.jc4u.xzkt.mapper.LoginLogMapper;
import club.jc4u.xzkt.mapper.UserMapper;
import club.jc4u.xzkt.service.AuthenticationService;
import club.jc4u.xzkt.utils.TokenUtil;
import cn.hutool.core.text.UnicodeUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;



@Transactional
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private LoginLogMapper loginLogMapper;

	private ResponseForm res;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResponseForm login(User user,HttpServletRequest request) {
		res = new ResponseForm();
		if (user == null || user.getStuNum() == null || user.getPassword() == null) {
			res.setError("参数不正确");
			return res;
		}
		User result = userMapper.selUserByNumAndPwd(user);
		//当返回的结果有效时
		if(result!=null){
			String token = null;
			try {
				token = TokenUtil.sign(result.getStuNum());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if(token!=null&&token.length()!=0){
				addLog(request,result);
				res.setContent(token);
				res.setStatus(true);
			}
		} else res.setError("账号或密码错误");
		return res;
	}

	@Override
	public ResponseForm checkToken(String token) {
		res = new ResponseForm();
		//事先已由拦截器检查过一次了
		if(TokenUtil.verify(token)){
			res.setContent("令牌有效");
			res.setStatus(true);
		} else res.setError("验证失败");
		return res;
	}

	private void addLog(HttpServletRequest request,User user){
		LoginLog log = new LoginLog();
		log.setIp(getIpAddr(request));
		log.setLocation(getLocation(getIpAddr(request)));
		log.setName(user.getName());
		log.setUser_id(user.getStuNum());
		log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		loginLogMapper.insNewLog(log);
	}



	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			if( ip.indexOf(",")!=-1 ){
				ip = ip.split(",")[0];
			}
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	private String getLocation(String ip) {StringBuffer sb = null;
		try {
			String str = "";
			URL url = new URL("https://api.ttt.sh/ip/qqwry/"+ip);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream(),"utf-8"));
			sb = new StringBuffer();
			while((str=reader.readLine())!=null){
				sb.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String location = sb.substring(sb.indexOf("address")+10,sb.indexOf("date")-3);
		return UnicodeUtil.toString(location);
	}
}
