package club.jc4u.xzkt.utils;

import org.springframework.util.DigestUtils;

public class MD5Util {

	public static String getMD5(String text){
		// 加密后的字符串
		return DigestUtils.md5DigestAsHex(text.getBytes());
	}

	private MD5Util(){}
}
