package com.jc4u.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 使用邮件发送密码重置验证码
 * 
 * @author HUTER_ERSHU
 * @version 1.0
 * @date 2019/5/20
 */
public class SendVerificationCodeEmail {
	// 发送邮件时的相关参数
	//服务器邮箱地址
	private final String mail_server_name = "jc4uos@163.com";
	//授权码
	private final String mail_key = "keyforjc4u";
	//接受者
	private String receive = "";
	private String sign = "JC4U Official Email";
	private String verificationCode = "";
	private String MAIL_TYPE = "密码重置验证码";
	private Authentication authentication = null;
	private Properties prop = null;

	// 只值提供一个有参构造
	public SendVerificationCodeEmail(String receive, String verificationCode) {
		this.receive = receive;
		this.verificationCode = verificationCode;
		// 进行配置初始化
		prop = new Properties();
		prop.put("mail.host", "smtp.163.com");
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", "true");
		// 邮箱验证
		authentication = new Authentication(mail_server_name, mail_key);
	}
	/**
	 * 设置邮件内容
	 * @param session
	 * @return
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	private MimeMessage createSimpleMail(Session session)
			throws AddressException, MessagingException, UnsupportedEncodingException {
		// 创建邮件对象
		MimeMessage mm = new MimeMessage(session);
		// 设置发件人
		mm.setFrom(new InternetAddress(mail_server_name, sign));
		// 设置收件人
		mm.setRecipient(Message.RecipientType.TO, new InternetAddress(receive));
		// 设置抄送人
//		mm.setRecipient(Message.RecipientType.CC, new InternetAddress(""));
		// 设置主题
		mm.setSubject(MAIL_TYPE);
		// 设置内容
		mm.setContent("<div align=\"center\"><h3>验证码为：" + verificationCode
				+ "</h3><h5 color=\"red\">请确认是本人操作！如有异常，请及时修改密码</h5></div>", "text/html;charset=utf-8");
		// 保存内容
		mm.saveChanges();
		
		return mm;
	}

	public void send() throws MessagingException, UnsupportedEncodingException {
		// 1.创建session
		Session session = Session.getDefaultInstance(prop, authentication);
		//是否查看日志
		session.setDebug(false);
		// 2.通过session获取Transport对象
		Transport transport = session.getTransport();
		// 3.连接邮件服务器
		transport.connect(mail_server_name, mail_key);
		// 4.创建邮件
		MimeMessage msg = createSimpleMail(session);
		// 5.发送邮件
		Transport.send(msg);
	}
}
