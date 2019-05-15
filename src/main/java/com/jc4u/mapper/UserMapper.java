package com.jc4u.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jc4u.entity.User;

public interface UserMapper {
	 
	@Select("SELECT * FROM t_users")
	List<User> selAll();
}
