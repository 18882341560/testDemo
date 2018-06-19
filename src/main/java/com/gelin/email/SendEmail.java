/*
package com.gelin.email;

import com.gelin.shiro.MyAuthenticator;

import java.util.Calendar;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

*/
/**
 * @version V1.0
 * @Description: 发送邮件的工具类
 * @Modified By:Ming Created in  16:51 2017/2/6
 * @Author: Ming
 * @param: id  用户id
 * @Description: 添加发送的短信的信息
 * @Date: 17:12 2017/2/6
 *//*

public class SendEmail {

    private final static String smtpHost = "smtp.163.com";//配置Email session对象
    private final static String messageType = "text/html;charset=UTF-8";//相应内容类型，编码类型
    private final static String subject = "iYo (社联网) 密码修改";//主题
    private final static String fromEmail = "gllovejava@163.com";//发送邮件的邮箱
    private final static String password = "GL18882341560";//密码(口令)

    @SuppressWarnings("static-access")
    public boolean sendMessage(String to, int id) {
        try {
            String messageText = appendString(id);
            //第一步：配置javax.mail.Session对象
            Properties props = new Properties();   // 创建Properties 类用于记录邮箱的一些属性
            props.put("mail.smtp.host", smtpHost);  //此处填写SMTP服务器
            props.put("mail.smtp.starttls.enable", "true");//使用 STARTTLS安全连接
            props.put("mail.smtp.port", "25");             //google使用465或587端口
            props.put("mail.smtp.auth", "true");       // 表示SMTP发送邮件，必须进行身份验证
            props.put("mail.debug", "true");
            Session mailSession = Session.getInstance(props, new MyAuthenticator(fromEmail, password));//此处填写你的账号和口令(16位口令)

            //第二步：编写消息
            InternetAddress fromAddress = new InternetAddress(fromEmail);// 设置发件人的邮箱
            InternetAddress toAddress = new InternetAddress(to); // 设置收件人的邮箱
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(fromAddress);
            message.addRecipient(RecipientType.TO, toAddress);
            message.setSentDate(Calendar.getInstance().getTime());
            message.setSubject(subject);   // 设置邮件标题
            message.setContent(messageText, messageType);// 设置邮件的内容体

            // 第三步：发送消息
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(smtpHost, fromEmail, password);
            transport.send(message, message.getRecipients(RecipientType.TO)); // 发送邮件啦

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    */
/**
 * @Author: Ming
 * @param: id  用户id
 * @Description: 添加发送的短信的信息
 * @Date: 17:12 2017/2/6
 *//*

    public static String appendString(int id) {
        int i;
        String t = "&nbsp";
        String messageText = "";

        for (i = 0; i < 4; i++) messageText += t;
        messageText += "xxxxxxxxx~<br/>";

        for (i = 0; i < 12; i++) messageText += t;
        messageText += "没关系，xxxxxxxxx<br/>";

        for (i = 0; i < 20; i++) messageText += t;
        messageText += "工作室地点：xxxxxxxxx~<br/><br/>";

        for (i = 0; i < 28; i++) messageText += t;
        messageText += "请点击：http://xxxxxxxxx";
        return messageText;
    }

}*/
