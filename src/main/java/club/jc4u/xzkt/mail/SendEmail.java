package club.jc4u.xzkt.mail;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * 使用邮件发送操作信息给用户
 *
 * @author TangXi
 * @version 1.0
 */
public class SendEmail {
    // 发送邮件时的相关参数
    //服务器邮箱地址
    private String mail_server_name;
    //授权码
    private String mail_key;
    //接受者
    private String receive = "";
    //签名
    private String sign;
    //类型（标题）
    private String mail_type;
    private String mail_frame;
    private Authentication authentication = null;
    private Properties prop = null;
    //待发送的信息
    private String  verificationCode;

    public SendEmail() {
    }

    // 只值提供一个有参构造
    public SendEmail(String receive, String verificationCode) {
        this.receive = receive;
        this.verificationCode = verificationCode;
        // 进行配置初始化
        prop = new Properties();
        prop.put("mail.host", "smtp.163.com");
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.auth", "true");
        //为了防止邮件连接超时
        final String smtpPort = "465";
        prop.setProperty("mail.smtp.port", smtpPort);
        prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.smtp.socketFactory.fallback", "false");
        prop.setProperty("mail.smtp.socketFactory.port", smtpPort);
        // 对mail进行参数设置
        mail_server_name = MailConfig.server_name;
        mail_key = MailConfig.key;
        mail_frame = MailConfig.frame;
        mail_type = MailConfig.type;
        sign = MailConfig.sign;
        // 邮箱验证
        authentication = new Authentication(mail_server_name, mail_key);
    }

    /**
     * 设置邮件内容
     *
     * @param session
     * @return
     * @throws AddressException
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    private MimeMessage initMail(Session session)
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
        mm.setSubject(mail_type);
        // 设置内容
        mm.setContent(getContent(), "text/html;charset=utf-8");
        // 保存内容
        mm.saveChanges();

        return mm;
    }

    private String getContent() {
        //创建一个tempString
        String temp = new String(mail_frame);
        return temp.replace("verificationCode",verificationCode);
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
        MimeMessage msg = initMail(session);
        // 5.发送邮件
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
    }
}
