package com.gelin.activemq;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Create by gl  2017/11/14 10:18
 * 消费者，就是接受消息
 */
public class NoPersistenceReceiver {
    //默认连接用户名
    private static String USERNAME;
    //默认连接密码
    private static String PASSWORD;
    //默认连接地址
    private static String BROKEURL;
    private static String TOPICNAME;//其他的topic
    private static String TOPICNAME1;//机号，机型的topic

    static {
        Properties pps = new Properties();
        InputStream in = null;
        try {
//            in = new BufferedInputStream(new FileInputStream("/static/mq.properties"));
            in = NoPersistenceSender.class.getClassLoader().getResourceAsStream("static/mq.properties");
            pps.load(in);
            USERNAME = pps.getProperty("USERNAME");
            PASSWORD = pps.getProperty("PASSWORD");
            BROKEURL = pps.getProperty("URL");
            TOPICNAME = pps.getProperty("TOPICNAME");
            TOPICNAME1 = pps.getProperty("TOPICNAME1");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //有两个topic
    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection = null;//连接

        Session session;//会话 接受或者发送消息的线程
        Destination destination;//消息的目的地

        MessageConsumer messageConsumer;//消息的消费者

        //实例化连接工厂(连接到ActiveMQ服务器)
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);

        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
            //生产者将消息发送到MyTopic，所以消费者要到MyTopic去取
            destination = session.createTopic(TOPICNAME);
            //创建消息消费者
            messageConsumer = session.createConsumer(destination);

            Message message = messageConsumer.receive();
            while (message != null) {
                TextMessage txtMsg = (TextMessage) message;
                txtMsg.acknowledge();

                //得到json字符串数据,做其他操作......
                String input = txtMsg.getText();

                //这是例子，使用fastjson，转集合对象,有aerocade,airport,city,company,country,province,flightnum,flighttype
                //Map<String,Object> map=(Map<String,Object>) JSON.parse(input);
                //List<aerocade> aerocades=(List<aerocade>)map.get("aerocade");

                System.out.println("收到消息：" + input);

                message = messageConsumer.receive(1000L);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
