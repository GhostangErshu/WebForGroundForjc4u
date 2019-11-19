package club.jc4u.xzkt.serviceImpl;

import club.jc4u.xzkt.entity.Resource;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.mapper.SrcMapper;
import club.jc4u.xzkt.service.SrcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SrcServiceImpl implements SrcService {

	//这里的注解因为和实体类冲突，故使用全路径
	@Autowired
	private SrcMapper srcMapper;

	private ResponseForm res;

	public ResponseForm getAllDownloadInfo() {
		res = new ResponseForm();
		List<Resource> resources = srcMapper.selAll();
		if(resources!=null){
			res.setContent(resources);
			res.setStatus(true);
		} else res.setError("获取资源信息失败");
		return res;
	}

	@Override
	public ResponseForm getDetailInfo(String id) {
		res = new ResponseForm();
		if(id!=null){
			Resource resource = srcMapper.selOneById(id);
			if(resource!=null){
				res.setContent(resource);
				res.setStatus(true);
			} else res.setError("查询时错误");
		} else res.setError("参数错误");
		return res;
	}

	//更新浏览次数
	@Override
	public ResponseForm increseVisitNum(String id) {
		res = new ResponseForm();
		if(id!=null){
			//更新浏览次数
			int num = srcMapper.updVisitNum(id);
			if(num!=0){
				res.setContent("增加成功");
				res.setStatus(true);
			} else res.setError("更新失败");
		} else res.setError("参数错误");
		return res;
	}

}
