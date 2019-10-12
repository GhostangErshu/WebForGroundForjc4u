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

}
