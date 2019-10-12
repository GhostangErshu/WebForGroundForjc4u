package club.jc4u.xzkt.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/imageCode")
@RestController
public class ImageCodeController {
	private LineCaptcha lineCaptcha = null;
	
	@RequestMapping("/getImage")
	public void getImage(HttpServletResponse resp) throws IOException {
		lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
		BufferedImage image = lineCaptcha.getImage();
		ImageIO.write(image, "jpg", resp.getOutputStream());
	}
	
	@RequestMapping("/getCode")
	public String getCode() {
		return lineCaptcha.getCode();
	}
}
