package club.jc4u.xzkt.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import club.jc4u.xzkt.entity.HistoryNode;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.mapper.HistoryNodeMapper;
import club.jc4u.xzkt.service.HistoryNodeService;
import org.springframework.stereotype.Service;


@Service
public class HistoryNodeServiceImpl implements HistoryNodeService {
	
	@Resource
	private HistoryNodeMapper historyNodeMapper;

	private ResponseForm res;

	@Override
	public ResponseForm getAllNode() {
		res = new ResponseForm();
		//获取节点信息
		List<HistoryNode> historyNodes = historyNodeMapper.selAll();
		if(historyNodes!=null){
			res.setStatus(true);
			res.setContent(historyNodes);
		} else res.setError("历史节点信息查询失败");
		return res;
	}
	

}
