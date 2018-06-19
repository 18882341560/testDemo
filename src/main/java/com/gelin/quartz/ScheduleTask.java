package com.gelin.quartz;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 葛林 on 2017/7/19.
 * spring 自带的定时器
 */
@Component
@Configurable
@EnableScheduling  //标注启动定时任务。
public class ScheduleTask {

//    @Scheduled(fixedRate = 1000*30) //定义某个定时任务
//    public void reportCurrenttime(){
//        System.out.println("Scheduling Tasks Examples: The time is now " +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//    }
//
//     @Scheduled(cron = "0 */1 * * * *")
//     public void reportCurrentByCron(){
//         System.out.println("Scheduling Tasks Examples By Cron: The time is now " +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//     }


}
