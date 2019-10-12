package club.jc4u.xzkt.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import club.jc4u.xzkt.entity.ImgDataForEditor;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.mapper.UserMapper;
import club.jc4u.xzkt.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Transactional
@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private UserMapper userMapper;

	private ResponseForm res;

	//存放头像的路径
	private final String HEAD_IMG_PATH = "/uploadFiles/images/headImg";
	//存放编辑框图片的路径
	private final String EDITOR_IMG_PATH = "/uploadFiles/images/editor";
	//存放源文件的路径
	private final String JAVA_CODE_PATH = "/uploadFiles/code/java";

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResponseForm uploadHeadImg(HttpServletRequest req, MultipartFile file) {
		res = new ResponseForm();
		String realPath = getRealPath(req, HEAD_IMG_PATH);
		//获取学号
		String stuNum = req.getParameter("stuNum");
		//学号成功读取
		if (stuNum != null) {
			String resultPath = saveFile(realPath, file);
			userMapper.updUserHead(stuNum, getServerPath(req)+HEAD_IMG_PATH+"/"+resultPath);
			//当没有异常发生
			res.setStatus(true);
			res.setContent("头像更新成功");
		} else res.setError("参数不正确，保存失败，请稍后重试！");
		return res;
	}

	@Override
	public ResponseForm uploadCodeFile(HttpServletRequest req, MultipartFile file) {
		res = new ResponseForm();
		String realPath = getRealPath(req, JAVA_CODE_PATH);
		String resultPath = saveFile(realPath, file);
		if (realPath != null && realPath.length() != 0) {
			//当没有异常发生
			res.setStatus(true);
			res.setContent(getServerPath(req)+JAVA_CODE_PATH+"/"+resultPath);
		} else res.setError("上传源文件失败，请稍后重试！");
		return res;
	}

	@Override
	public ImgDataForEditor uploadImgForEditor(HttpServletRequest req, MultipartFile file) {

		ImgDataForEditor data = new ImgDataForEditor();
		String realPath = getRealPath(req, EDITOR_IMG_PATH);
		String resultPath = saveFile(realPath, file);
		if (resultPath != null && realPath.length() != 0) {
			data.setErrno(0);
			// 添加图片地址
			data.getData().add(getServerPath(req)+EDITOR_IMG_PATH+"/"+resultPath);
		}
		return data;
	}

	/**
	 * 文件保存
	 *
	 * @param realPath
	 * @param uploadFile
	 * @return 返回文件名
	 */
	private String saveFile(String realPath, MultipartFile uploadFile) {
		// 判断目录是否存在，若是不存在则创建一个目录
		File path = new File(realPath);
		if (!path.exists())
			path.mkdirs();
		// 使用UUID加前缀命名文件，防止名字重复被覆盖
		String prefix = UUID.randomUUID().toString();
		prefix = prefix.replace("-", "");
		// 获取原文件的后缀名
		String suffix = uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf("."));
		// 拼接文件名
		String fileName = prefix + suffix;
		String result = null;
		try {
			OutputStream out = new FileOutputStream(realPath + "/" + fileName);
			IOUtils.copy(uploadFile.getInputStream(), out);
			// 文件保存成功后将文件名称及路径进行返回
			result = fileName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private String getRealPath(HttpServletRequest req, String relativePath) {
//		return req.getServletContext().getRealPath(relativePath);
		return "/usr/local/nginx/FileServer/html/"+relativePath;
	}

	private String getServerPath(HttpServletRequest req){
		//这里的图片服务器端口为7979
		return "http://" + req.getServerName() + ":" + 7979;
	}
}