package club.jc4u.xzkt.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import club.jc4u.xzkt.entity.Carousel;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.mapper.CarouselMapper;
import club.jc4u.xzkt.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarouselServiceImpl implements CarouselService {
	@Autowired
	private CarouselMapper CarouselMapper;

	private ResponseForm res;

	@Override
	public ResponseForm getLastCarouselInfo() {
		res = new ResponseForm();
		List<Carousel> resultList = null;
		//表示轮播图最多只有6张
		int num = 6;
		try{
			List<Carousel> list = CarouselMapper.selAllInfo();
			//get min number
			int length = list.size()<num?list.size():num;
			resultList = new ArrayList<>();
			for(int i=0;i<length;i++) {
				//获取最后几个
				resultList.add(list.get(list.size()-1-i));
			}
		} catch (Exception e){
			res.setError(e.getMessage());
		}
		res.setStatus(true);
		res.setContent(resultList);
		return res;
	}

}
