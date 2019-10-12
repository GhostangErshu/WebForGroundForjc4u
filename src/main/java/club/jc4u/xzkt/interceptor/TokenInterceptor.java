package club.jc4u.xzkt.interceptor;

import club.jc4u.xzkt.utils.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * 关于登录的拦截器配置
 *
 * @author TangXi
 */
public class TokenInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (isWhitePage(request.getRequestURI()))
			return true;
		//检查token
		String token = request.getParameter("token");
		//更具结果看是否放行
		if (token != null && token != "")
			return TokenUtil.verify(token);
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	private boolean isWhitePage(String requestURI) {
		ArrayList<String> passPages = new ArrayList<>();
		passPages.add("countdown");
		passPages.add("video");
		passPages.add("website");
		passPages.add("notice");
		passPages.add("carousel");
		passPages.add("uploadFiles");
		passPages.add("historyEvent");
		passPages.add("verify");
		passPages.add("image");
		passPages.add("imageCode");
		passPages.add("file");
		passPages.add("/user/checkExist");
		passPages.add("/sendEmailForResetPwd");
		passPages.add("ResetPwd");
		//排除刚刚登录的情况
		for (String path : passPages)
			if (requestURI.indexOf(path) != -1)
				return true;
		return false;
	}

}
