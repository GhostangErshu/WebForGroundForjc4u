package com.jc4u.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jc4u.service.impl.SrcServiceImpl;

@Controller
public class SrcsController {
	@Resource
	private SrcServiceImpl srcServiceImpl;

	@RequestMapping("getAllSrcInfos.jc4u")
	@ResponseBody
	public String getAllInfo() throws JsonProcessingException {
		//需要将对象转换为json字符串
		ObjectMapper mapper = new ObjectMapper();
		List<com.jc4u.entity.Resource> allDownloadInfo = srcServiceImpl.getAllDownloadInfo();
		//返回json字符串
		return mapper.writeValueAsString(allDownloadInfo);
	}
}

