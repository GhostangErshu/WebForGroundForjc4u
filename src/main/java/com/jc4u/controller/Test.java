package com.jc4u.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jc4u.entity.User;
import com.jc4u.service.impl.UserServiceImpl;

@Controller
public class Test {
	@Resource
	private UserServiceImpl userServiceImpl;

	@RequestMapping("test")
	public String test(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<User> list = userServiceImpl.selAllUser();
		ObjectMapper mapper = new ObjectMapper();
		req.setAttribute("list", mapper.writeValueAsString(list));
		return "index.jsp";
	}

	/**
	 * restful风格参数加上ModelAndView
	 * 
	 * @param name
	 * @param age
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("test22/{name}/{age}")
	public ModelAndView test2(@PathVariable("name") String name, @PathVariable("age") String age)
			throws JsonProcessingException {
		ModelAndView mav = new ModelAndView("/index.jsp");
		List<User> list = userServiceImpl.selAllUser();
		ObjectMapper mapper = new ObjectMapper();
		mav.addObject("list", mapper.writeValueAsString(list));
		mav.addObject("name", name);
		mav.addObject("age", age);
		return mav;
	}

	@RequestMapping(value = "test33", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String test33(HttpServletRequest req) throws IOException {
	

		return "哈ha梁林真是棒棒的";
	}
	@RequestMapping("test8.jc4u")
	@ResponseBody
	public String testWeb() throws JsonProcessingException {
		List<User> list = userServiceImpl.selAllUser();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(list);
	}
}
