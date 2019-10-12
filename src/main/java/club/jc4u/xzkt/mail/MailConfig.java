package club.jc4u.xzkt.mail;

/**
 * @Author TangXi
 * @Date 19-8-29 下午9:15
 */
public interface MailConfig {

	String server_name = "jc4uos@163.com";
	String key = "keyforjc4u";
	String sign = "JC4U Official Email";
	String type = "密码重置验证码";
	String frame = "<div align=\"center\"><h3>验证码为：  verificationCode" +"</h3><h5>请确认是本人操作！如有异常，请及时修改密码</h5></div>";
}
