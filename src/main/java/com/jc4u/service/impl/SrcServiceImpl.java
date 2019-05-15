package com.jc4u.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jc4u.entity.Resource;
import com.jc4u.mapper.SrcMapper;
import com.jc4u.service.SrcService;

@Service
public class SrcServiceImpl implements SrcService{

	//这里的注解因为和实体类冲突，故使用全路径
	@javax.annotation.Resource
	private SrcMapper srcMapper;
	
	@Override
	public List<Resource> getAllDownloadInfo() {
		return srcMapper.selAll();
	}

}
