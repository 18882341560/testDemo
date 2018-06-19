package com.gelin.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by 葛林 on 2018/1/15.
 */
public class MQTTSubscribe implements MqttCallback {


    //public static final String HOST = "tcp://10.0.0.250:1884";
    public static final String HOST = "tcp://127.0.0.1:61613";

    public static final String TOPIC = "gl";
    private static final String clientid = "subscriber";
    private MqttClient client;
    private MqttConnectOptions options;
    private String userName = "admin";
    private String passWord = "password";
    private ScheduledExecutorService scheduler;


    public void startReconnect() {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                if (!client.isConnected()) {
                    try {
                        client.connect(options);
                        System.out.println("重连成功");
                    } catch (MqttSecurityException e) {
                        e.printStackTrace();
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 0 * 1000, 10 * 1000, TimeUnit.MILLISECONDS);
    }

    private void start() {
        try {
            client = new MqttClient(HOST, clientid, new MemoryPersistence());
            options = new MqttConnectOptions();
            options.setCleanSession(false);
            options.setUserName(userName);
            options.setPassword(passWord.toCharArray());
            options.setConnectionTimeout(10);
            options.setKeepAliveInterval(20);
            client.setCallback(this);
//            MqttTopic topic = client.getTopic(TOPIC);
//            options.setWill(topic, "close".getBytes(), 2, true);
            client.connect(options);
            int[] Qos = {2};
            String[] topic1 = {TOPIC};
            client.subscribe(topic1, Qos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws MqttException {
        MQTTSubscribe client = new MQTTSubscribe();
        client.start();
    }

    public void connectionLost(Throwable cause) {
        startReconnect();
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        try {
            System.out.println("deliveryComplete---------" + token.isComplete());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("Message arrived on topic:" + topic);
        System.out.println("Message arrived on QoS:" + message.getQos());
        System.out.println("Message arrived on content:" + new String(message.getPayload()));
    }
}
