package club.jc4u.xzkt.interceptor;

import club.jc4u.xzkt.utils.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 关于admin的拦截器配置
 *
 * @author TangXi
 */
public class AdminInterceptor implements HandlerInterceptor {

	//初始化权限表格
	private HashMap<String, Integer> powerLevel = new HashMap<>();

	{
		powerLevel.put("class", 3);
		powerLevel.put("grade", 2);
		powerLevel.put("task", 2);
		powerLevel.put("grade", 3);
		powerLevel.put("user", 3);
		powerLevel.put("log", 3);
		powerLevel.put("super", 9);
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String token = request.getParameter("token");
		int powerLevel = 0;
		//更具结果看是否放行
		if (token != null && token != "") {
			powerLevel = Integer.parseInt(TokenUtil.getPowerLevel(token));
		}
		return checkPowerLevel(request.getRequestURI(), powerLevel);
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	private boolean checkPowerLevel(String requestURI, int level) {
		for (String e : powerLevel.keySet()) {
			//权限正确
			if (requestURI.indexOf(e) != 0 && level >= powerLevel.get(e))
				return true;
		}
		return false;
	}

}
