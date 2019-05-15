package com.jc4u.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jc4u.entity.User;
import com.jc4u.mapper.UserMapper;

public class TestWithMybatis {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("Mybatis.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selAll();
		System.out.println(list);
	}
}
