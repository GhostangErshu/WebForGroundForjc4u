package club.jc4u.xzkt.service;


import club.jc4u.xzkt.entity.ImgDataForEditor;
import club.jc4u.xzkt.entity.ResponseForm;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileService {
	 //上传头像
	 ResponseForm uploadHeadImg(HttpServletRequest req, MultipartFile file);
	 //上传源代码
	 ResponseForm uploadCodeFile(HttpServletRequest req,MultipartFile file);
	 //上传编辑器图片(满足前端接口需要)
	 ImgDataForEditor uploadImgForEditor(HttpServletRequest req, MultipartFile file);
}
