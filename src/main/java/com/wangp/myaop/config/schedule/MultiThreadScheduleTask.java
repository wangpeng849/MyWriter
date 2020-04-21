package com.wangp.myaop.config.schedule;

import org.omg.PortableServer.THREAD_POLICY_ID;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author wangp
 * @Date 2020/4/21
 * @Version 1.0
 */
@EnableScheduling
@EnableAsync //开启多线程
@Component
public class MultiThreadScheduleTask {

    @Async
    @Scheduled(fixedRate = 1000) //间隔一秒  cron 是表达式表达   fixedDelay是按毫秒表示  fixedRate是上次任务结束等待时间
    public void first() throws InterruptedException {
        System.out.println("第一个定时任务开始：" + LocalDateTime.now().toLocalTime() + "\r\n线程:" + Thread.currentThread().getName());
        Thread.currentThread().sleep(1000*5);
    }

    @Async
    @Scheduled(fixedDelay = 5000) //间隔一秒  cron 是表达式表达   fixedDelay是按毫秒表示
    public void second() throws InterruptedException {
        System.out.println("第二个定时任务开始：" + LocalDateTime.now().toLocalTime() + "\r\n线程:" + Thread.currentThread().getName());
    }
}
