package club.jc4u.xzkt.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 关于跨域访问的拦截器配置
 * @author TangXi
 *
 */
public class CORSInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//解决跨域问题
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	        response.setHeader("Access-Control-Allow-Credentials", "true");
	        response.setHeader("P3P", "CP=CAO PSA OUR");
	        if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
	            response.addHeader("Access-Control-Allow-Methods", "POST,GET,TRACE,OPTIONS");
	            response.addHeader("Access-Control-Allow-Headers", "Content-Type,Origin,Accept");
	            response.addHeader("Access-Control-Max-Age", "120");
	        }
	    //放行
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
