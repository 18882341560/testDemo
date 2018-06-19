package com.gelin.quartz;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * Created by 葛林 on 2017/7/19.
 */
@Configuration
@Component // 此注解必加
@EnableScheduling // 此注解必加
public class ScheduleTasks {

    public void sayHello() {
        System.out.println("葛林的第一次Quartz!!!");
    }
}
