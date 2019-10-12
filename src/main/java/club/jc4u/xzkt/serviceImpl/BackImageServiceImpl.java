package club.jc4u.xzkt.serviceImpl;

import java.util.List;

import club.jc4u.xzkt.entity.BackgroundImg;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.mapper.BackImageMapper;
import club.jc4u.xzkt.service.BackImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class BackImageServiceImpl implements BackImageService {

	@Autowired
	private BackImageMapper backImageMapper;

	private ResponseForm res;

	@Override
	public ResponseForm getAllBackImages() {
		res = new ResponseForm();
		List<BackgroundImg> result = backImageMapper.selAll();
		if(result==null)
			res.setError("查询失败");
		else {
			res.setContent(result);
			res.setStatus(true);
		}
		return res;
	}

	@Override
	public ResponseForm getRandomOne() {
		res = new ResponseForm();
		 List<BackgroundImg> list = backImageMapper.selAll();
		 //获取一个随机的下标
		 int index = (int) (Math.random()*100000%list.size());
		BackgroundImg result = list.get(index);
		if(result==null)
			res.setError("获取图片失败");
		else {
			res.setContent(result);
			res.setStatus(true);
		}
		return res;
	}
}
