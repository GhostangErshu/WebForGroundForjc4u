package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ImgDataForEditor;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.serviceImpl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "/file", method = RequestMethod.POST)
public class FileController {
	@Autowired
	private FileServiceImpl fileService;

	@RequestMapping("/uploadHeadImg")
	public ResponseForm uploadHeadImg(HttpServletRequest req, @RequestParam("file") MultipartFile uploadFile) {
		return fileService.uploadHeadImg(req,uploadFile);
	}

	@RequestMapping("/uploadCodeFile")
	public ResponseForm uploadJavaFile(HttpServletRequest req, @RequestParam("file") MultipartFile uploadFile) {
		return fileService.uploadCodeFile(req,uploadFile);
	}

	@RequestMapping("/uploadImgForEditor")
	public ImgDataForEditor uploadImgForEditor(HttpServletRequest req, @RequestParam("file") MultipartFile uploadFile) {
		return fileService.uploadImgForEditor(req,uploadFile);
	}
}
