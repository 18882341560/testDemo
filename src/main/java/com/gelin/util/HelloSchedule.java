package com.gelin.util;

import com.fasterxml.jackson.databind.BeanProperty;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 葛林 on 2017/7/18.
 */
public class HelloSchedule {

    public static void main1() throws SchedulerException {
        Date date = new Date();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        /*JobDetail jobDetail= JobBuilder.newJob(QuartzTest.class)
                .withIdentity("myjob","group1") //group 不写默认default
                .usingJobData("message","hello jobDetail") //传入参数
                .usingJobData("mathjob",3.14F).build();*/
        JobDetail jobDetail = JobBuilder.newJob(QuartzTest.class)
                .withIdentity("myjob", "group1")
                .build();

        //System.out.println(jobDetail.getKey().getName());
        //System.out.println(jobDetail.getKey().getGroup());
        //System.out.println(jobDetail.getJobClass().getName());


        //定义立即执行，每隔2秒执行一次
       /* Trigger trigger= TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","group1")//定义标识，定义组
                .usingJobData("message","hello trigger")   //参入参数
                .usingJobData("DoubleTrigger",2.0D)
                .startNow() //现在开始执行
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();*/
        //定义3秒之后执行
        date.setTime(date.getTime() + 3000);//得到时间戳加3000毫秒
        //定义结束时间
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 6000);//距离开始时间后的6秒结束
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startAt(date) //开始执行时间
                .endAt(endDate)  //最后执行时间
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();//withIntervalInSeconds(2)每隔2秒钟执行一次 repeatForever()无限执行

        //创建Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);//将前两者绑定在一起执行
    }

    //SimpleTrigger的一些用法
    public static void main2() throws SchedulerException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        JobDetail jobDetail = JobBuilder.newJob(QuartzTest.class)
                .withIdentity("myjob", "group1")
                .build();

        //距离当前4秒后执行且只执行一次
        /*Date date=new Date();
        date.setTime(date.getTime()+4000);
        SimpleTrigger trigger= (SimpleTrigger)TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","group1")
                .startAt(date)
                .build();*/
        //距离当前时间4秒钟后首次执行任务，之后每隔两秒钟重复执行一次任务
        /*Date date=new Date();
        date.setTime(date.getTime()+4000);
        SimpleTrigger trigger= (SimpleTrigger)TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","group1")
                .startAt(date)     //withRepeatCount() 重复的次数  SimpleTrigger.REPEAT_INDEFINITELY无限次
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(
                        2
                ))   //会打印3次，2是重复两次
                .build();*/

        //距离当前时间6秒后结束
        Date date = new Date();
        date.setTime(date.getTime() + 4000);
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 6000);  //第6秒就不会执行了
        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startAt(date)     //withRepeatCount() 重复的次数  SimpleTrigger.REPEAT_INDEFINITELY无限次
                .endAt(endDate)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(
                        2
                ))   //会打印3次，2是重复两次
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    //CronTrigger的一些用法
    public static void main3() throws SchedulerException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        JobDetail jobDetail = JobBuilder.newJob(QuartzTest.class)
                .withIdentity("myjob", "group1")
                .build();

        //每秒钟触发一次任务
        /*CronTrigger trigger= (CronTrigger)TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .build();*/
        //2017年内每天10点15分触发一次  0 15 10 ? * * 2017
        //每天的14点整至14点59分59秒，以及18点整至18点59分59秒，每5秒钟触发一次 0/5 * 17,18 * * ?
        //每月周一至周五的10点15分触发一次 0 15 10 ? * 1-5
        //每月最后一天的10点15分触发一次 0 15 10 L * ?
        //每月第三个周五的10点15分触发一次 0 15 10 ? * 6#3
        CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 47 14 ? * 6#3"))
                .build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    //stdScheduler
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        JobDetail jobDetail = JobBuilder.newJob(QuartzTest.class)
                .withIdentity("myjob2", "group2")
                .build();

        CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))
                .build();
        StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start(); //启动   standby() 将Scheduler暂时挂起
        Date date = scheduler.scheduleJob(jobDetail, trigger);
        Thread.sleep(3000);
        scheduler.standby();
        Thread.sleep(5000);
        scheduler.start();
    }
    //shutdown() 完全关闭,可以传入参数boolean shoudown(true)等待所有正在执行的job执行完毕后再关闭。false直接关闭


}
