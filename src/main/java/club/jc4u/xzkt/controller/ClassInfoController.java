package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.ClassInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/classInfo",method = RequestMethod.GET)
@RestController
public class ClassInfoController {
	
	@Autowired
	private ClassInfoServiceImpl classInfoService;

	@RequestMapping("/getInfo")
	ResponseForm getClassInfoById(String id){
		return classInfoService.getUserRealtimeClassInfoById(id);
	}
	
	@RequestMapping("/listInfo")
	ResponseForm getAllClassInfoById(String id){
		return classInfoService.getUserAllClassInfoById(id);
	}
}
