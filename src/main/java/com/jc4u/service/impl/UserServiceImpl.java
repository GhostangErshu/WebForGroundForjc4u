package com.jc4u.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jc4u.entity.User;
import com.jc4u.mapper.UserMapper;
import com.jc4u.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

	
	@Override
	public List<User> selAllUser() {
		return userMapper.selAll();
	}

}
