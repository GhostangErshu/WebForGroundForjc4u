package com.jc4u.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jc4u.entity.Resource;

public interface SrcMapper {
	
	@Select("SELECT * FROM t_srcs")
	List<Resource> selAll();
}
