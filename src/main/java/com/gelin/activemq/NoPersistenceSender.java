package com.gelin.activemq;


import com.alibaba.fastjson.JSON;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.io.*;
import java.util.*;

/**
 * Create by gl  2017/11/13 13:57
 * 生产者
 */
public class NoPersistenceSender {

    private static Logger logger = LoggerFactory.getLogger(NoPersistenceSender.class);

    //默认连接用户名 ActiveMQConnection.DEFAULT_USER;
    private static String USERNAME;
    //默认连接密码 ActiveMQConnection.DEFAULT_PASSWORD
    private static String PASSWORD;
    //默认连接地址
    private static String BROKEURL;
    //topic的名称
    private static String TOPICNAME;
    private static String TOPICNAME1;
    //连接
    private static Connection connection;
    //会话
    private static Session session;

    static {
        Properties pps = new Properties();
        InputStream in = null;
        try {
            in = NoPersistenceSender.class.getClassLoader().getResourceAsStream("static/mq.properties");
//            in = new BufferedInputStream(new FileInputStream("/static/mq.properties"));
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

    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConnection() {
        //连接工厂
        ConnectionFactory connectionFactory;
        //实例化连接工厂(连接到ActiveMQ服务器)
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
        try {
            connection = connectionFactory.createConnection();
            return connection;
        } catch (JMSException e) {
            logger.debug("连接到ActiveMQ服务器异常");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到session
     *
     * @return
     */
    public static Session getSession() {
        Connection connection = getConnection();
        try {
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
            return session;
        } catch (JMSException e) {
            logger.debug("与activemq会话异常");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送给TOPICNAME1的topic
     *
     * @param map
     */
    public static void sentMessageToTOPICNAME1(Map map) {
        try {
            Session session = getSession();
            Destination destination = session.createTopic(TOPICNAME1);
            //创建消息生产者
            MessageProducer messageProducer = session.createProducer(destination);
            //发送消息
            sendMessage(session, messageProducer, map);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送给TOPICNAME的topic
     *
     * @param map
     */
    public static void sentMessageToTOPICNAME(Map map) {
        try {
            Session session = getSession();
            Destination destination = session.createTopic(TOPICNAME);
            //创建消息生产者
            MessageProducer messageProducer = session.createProducer(destination);
            //发送消息
            sendMessage(session, messageProducer, map);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    /**
     * 发送消息
     *
     * @param session
     * @param messageProducer 消息生产者
     * @throws Exception
     */
    public static void sendMessage(Session session, MessageProducer messageProducer, Map map) throws Exception {
        String text = JSON.toJSONString(map);
        //创建一条文本消息
        TextMessage message = session.createTextMessage(text);
        //通过消息生产者发出消息
        messageProducer.send(message);
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("1", 2);
        map.put("3", 4);
        map.put("5", 6);
        sentMessageToTOPICNAME(map);
    }
}
