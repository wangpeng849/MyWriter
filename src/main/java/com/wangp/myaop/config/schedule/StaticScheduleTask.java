package com.wangp.myaop.config.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @Author wangp
 * @Date 2020/4/21
 * @Version 1.0
 */
@Configuration
@EnableScheduling
public class StaticScheduleTask {
    //添加记时任务
    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTask(){
       // System.err.println("执行任务："+ LocalDateTime.now());
    }
}
