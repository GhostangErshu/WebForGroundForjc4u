package club.jc4u.xzkt.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.Video;
import club.jc4u.xzkt.mapper.VideoMapper;
import club.jc4u.xzkt.service.VideoService;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

	@Resource
	private VideoMapper videoMapper;

	private ResponseForm res;

	@Override
	public ResponseForm getAllVideoInfo() {
		res = new ResponseForm();
		List<Video> videos = videoMapper.selAll();
		if(videos!=null){
			res.setContent(videos);
			res.setStatus(true);
		} else res.setError("获取视频信息失败");
		return res;
	}

	@Override
	public ResponseForm getVideoInfo(String id) {
		res = new ResponseForm();
		Video video = videoMapper.selInfo(id);
		if(video!=null){
			res.setContent(video);
			res.setStatus(true);
		} else res.setError("获取视频信息失败");
		return res;
	}
}
