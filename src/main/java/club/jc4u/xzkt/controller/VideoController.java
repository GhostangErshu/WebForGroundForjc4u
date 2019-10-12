package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
public class VideoController {

	@Autowired
	private VideoServiceImpl videoService;

	@RequestMapping("/listInfo")
	ResponseForm getAllVideoInfo(){
		return videoService.getAllVideoInfo();
	}

	@RequestMapping("/getInfo")
	ResponseForm getVideoInfo(String id){
		return videoService.getVideoInfo(id);
	}
}
