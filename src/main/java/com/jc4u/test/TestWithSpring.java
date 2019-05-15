package com.jc4u.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jc4u.entity.User;
import com.jc4u.service.UserService;

public class TestWithSpring {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		SqlSessionFactory factory = ac.getBean(SqlSessionFactory.class);
//		SqlSession session = factory.openSession();
//		UserMapper mapper = session.getMapper(UserMapper.class);
//		List<User> list = mapper.selAll();
//		System.out.println(list);
		UserService bean = ac.getBean("userServiceImpl",UserService.class);
		List<User> list = bean.selAllUser();
		System.out.println(list);
	}
}
