package com.wangp.myaop.timetask;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newScheduledThreadPool;

public class TimerDemo {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 定时间隔3秒");
            }
        };
        TimerTask task2 = new TimerTask() {
            int count = 1;
            @Override
            public void run() {
//                System.out.println(Thread.currentThread().getName() + " 定时间隔3秒");
                System.out.println("加载中：" + count++ + "/100");
            }
        };
        Timer t = new Timer();
        ScheduledExecutorService t2 = newScheduledThreadPool(2);
        long delay = 1000;
        long intevalTime = 3000;
//        t.scheduleAtFixedRate(task, delay, intevalTime);
        t2.scheduleAtFixedRate(task2,100,300, TimeUnit.MILLISECONDS);
//        t.schedule(task,delay);
    }
}
