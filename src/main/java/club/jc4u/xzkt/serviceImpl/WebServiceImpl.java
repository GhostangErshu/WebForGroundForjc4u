package club.jc4u.xzkt.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.Website;
import club.jc4u.xzkt.mapper.WebsiteMapper;
import club.jc4u.xzkt.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WebServiceImpl implements WebsiteService {
	@Autowired
	private WebsiteMapper websiteMapper;

	private ResponseForm res;

	@Override
	public ResponseForm getAllWebsiteInfo() {
		res = new ResponseForm();
		List<Website> websites = websiteMapper.selAllInfo();
		if (websites != null) {
			res.setStatus(true);
			res.setContent(websites);
		} else res.setError("获取推荐网站信息失败");
		return res;
	}
}
