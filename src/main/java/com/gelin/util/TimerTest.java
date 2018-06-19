package com.gelin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by 葛林 on 2017/7/18.
 */
public class TimerTest {

    //缺陷：1.管理并发任务的缺陷
    //     2.异常处理的缺陷;出现异常时，所有任务停止

    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();
        MyTimerTask myTimerTask = new MyTimerTask("gelin");
        //timer.schedule(myTimerTask,2000L,1000L);//首次执行是在当前的2秒之后，每隔1秒执行一次
        //timer.schedule(task,time);在时间等于或超过time的时候执行且只执行一次
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse("2017-07-18 14:29:00");
        calendar.add(Calendar.SECOND, 3);
        myTimerTask.setName("test1");
        //timer.schedule(myTimerTask,date);
        //timer.schedule(task,time,period)时间等于或超过time时首次执行task，之后每隔period毫秒重复一次task
        timer.schedule(myTimerTask, calendar.getTime(), 3000L);
        System.out.println(simpleDateFormat.format(new Date(myTimerTask.scheduledExecutionTime())));
        //timer.schedule(task,delay)等待delay毫秒后执行且只执行一次
        //timer.schedule(myTimerTask,2000L);
        //timer.schedule(task,delay,period);等待delay毫秒后，首次执行task，之后每隔period毫秒执行一次
        //timer.scheduleAtFixedRate();用法与上面一致


        //task其他重要函数
        //cancel();取消执行
        // long  scheduledExecutionTime() 返回此任务最近实际执行的已安排执行的时间


        //timer 其他重要函数
        //cancel() 终止此计时器，丢弃 所有 当前已安排的任务
        //purge() 从此计时器的任务队列中移除所有已取消的任务，返回从队列中移除的任务数


        //scheduleAtFixedRate(存在并发性)与schedule()的区别
        //当-6秒，每2秒执行一次时， 在当前时间scheduleAtFixedRate会连续执行3次，而schedule会从当前时间执行
        //schedule：下一次执行时间相对于上一次实际执行完成的时间点，因此执行时间会不断延后
        //scheduleAtFixedRate：下一次执行时间相对于上一次开始的时间点，因此执行时间不会延后，存在并发性
    }


}
