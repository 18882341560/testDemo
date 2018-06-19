/*
package com.gelin.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

*/
/**
 * Created by 葛林 on 2017/7/24.
 *//*

public class Mail5 {

    //用于给用户发送邮件的邮箱
    private static String from = "gllovejava@163.com";
    //邮箱的用户名
    private static String username = "gllovejava";
    //邮箱的密码
    private static String password = "gl18882341560";
    //发送邮件的服务器地址
    private static String host = "smtp.163.com";

    public static void main(String[] args) throws MessagingException {
        Properties prop = new Properties();
        prop.setProperty("mail.host", host);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        Session session = Session.getInstance(prop);
        session.setDebug(true);
        Transport ts = session.getTransport();
        ts.connect(host, username, password);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("18882341560@139.com"));
        message.setSubject("用户注册邮件");
        String info = "恭喜您注册成功，您的用户名：" + "dgdgf" + ",您的密码：" + "fdfgdfg" + "，请妥善保管，如有问题请联系网站客服!!";
        message.setContent(info, "text/html;charset=UTF-8");
        message.saveChanges();
    }


}
*/
