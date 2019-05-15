package com.jc4u.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 关于跨域访问的拦截器配置
 * @author HUTER_ERSHU
 *
 */
public class CORSInterceptor implements HandlerInterceptor{

	@Override
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

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
