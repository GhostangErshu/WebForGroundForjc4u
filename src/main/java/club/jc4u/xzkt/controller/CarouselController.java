package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.CarouselServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carousel")
public class CarouselController {

	@Autowired
	private CarouselServiceImpl carouselService;
	
	@RequestMapping("/getInfo")
	ResponseForm getCarouselInfo(){
		return carouselService.getLastCarouselInfo();
	}
}
