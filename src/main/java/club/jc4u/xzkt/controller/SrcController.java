package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.SrcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/source")
@RestController
public class SrcController {
	@Autowired
	private SrcServiceImpl srcServiceImpl;

	@RequestMapping("/listInfo")
	public ResponseForm getAllInfo(){
		return srcServiceImpl.getAllDownloadInfo();
	}
}

