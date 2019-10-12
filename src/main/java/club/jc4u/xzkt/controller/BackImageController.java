package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.BackImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/image",method = RequestMethod.GET)
public class BackImageController {

	@Autowired
	private BackImageServiceImpl backImageService;
	
	@RequestMapping("/getOne")
	ResponseForm getOneImage(){
		return backImageService.getRandomOne();
	}
}
