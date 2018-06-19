package com.gelin.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by 葛林 on 2017/7/23.
 * 成功
 */
public class MailUtils {

    public static void main(String[] args) {
        try {
            sendMail("962422150@qq.com","6666");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    /**
     * 发送邮件
     *
     * @param to   给谁发送
     * @param code 激活码
     */
    public static void sendMail(String to, String code) throws MessagingException {
        //创建链接对象
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        properties.setProperty("mail.smtp.host", "smtp.163.com");   // 发件人的邮箱的 SMTP 服务器地址
        properties.setProperty("mail.smtp.auth", "true");
        //properties.setProperty("host","value")因为是本地，不用设置
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //输入邮箱的账号和密码就可以登陆了
                return new PasswordAuthentication("gllovejava@163.com", "gl18882341560");
            }
        });

        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        message.setFrom(new InternetAddress("gllovejava@163.com"));
        //设置收件人   BC;CC需要了解
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //设置主题
        message.setSubject("葛林的邮件");
        //设置邮件的正文
        message.setContent("<h1>激活点击链接</h1><a href='http://localhost:8080/aaa/mail?code=" + code + "'>http://localhost:8080/aaa/mail?code=" + code + "</a>", "text/html;charset=UTF-8");//第二个参数是设置这是一个文本还是一个链接
        //发送激活邮件
        Transport.send(message);
    }

    //点击过后根据激活码在数据库中查找，然后激活

}
