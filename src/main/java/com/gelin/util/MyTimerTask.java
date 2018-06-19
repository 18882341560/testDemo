package com.gelin.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * Created by 葛林 on 2017/7/18.
 */
public class MyTimerTask extends TimerTask {

    private String name;

    private Integer count = 0;

    public MyTimerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        if (count < 4) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(simpleDateFormat.format(calendar.getTime()));
            System.out.println("当前名字为：" + name);
            count++;
        } else {
            cancel();
            System.out.println("取消执行");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
