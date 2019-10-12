package club.jc4u.xzkt.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import club.jc4u.xzkt.entity.Countdown;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.mapper.CountDownMapper;
import club.jc4u.xzkt.service.CountDownService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CountDownServiceImpl implements CountDownService {

	@Resource
	private CountDownMapper countDownMapper;

	private ResponseForm res;

	@Override
	public ResponseForm getMostRecentThing() {
		res = new ResponseForm();
		List<Countdown> list = countDownMapper.selAll();
		//获取现在的时间
		long now = new Date().getTime();
		//定义两个初始变量
		long temp = 0;
		int count = -1;
		for(int i = 0;i<list.size();i++) {
			//循环找到时间差最小的事件
			if(Long.parseLong(list.get(i).getTime())-now>temp) {
				temp = Long.parseLong(list.get(i).getTime());
				count = i;
			}
		}
		//when event is not found
		if(count==-1)
			res.setError("没有最近事件");
		else {
			res.setContent(list.get(count));
			res.setStatus(true);
		}
		return res;
	}

	
}
