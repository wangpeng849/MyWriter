package com.wangp.myaop.controller;

import com.wangp.myaop.mapper.RobotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newScheduledThreadPool;

@RestController
public class RobotController {

    int count = 0;

    @Autowired
    private RobotMapper robotMapper;

    @RequestMapping("/percent")
    public String send(){
        int count = robotMapper.getAllCount();
        int typeCount = robotMapper.getCount("cool");

        return "percent = "+ ((float)typeCount/(float)count)*100 + "%";
    }

    @RequestMapping("/time")
    public String timeSend(){
        go();
//        MyTimerTask timerTask = new MyTimerTask(count);
        String result =   "加载中：" + this.count + "/100";
//        ScheduledExecutorService scheduledExecutorService = newScheduledThreadPool(1);
//        scheduledExecutorService.scheduleAtFixedRate(timerTask,100,500, TimeUnit.MILLISECONDS);
        System.out.println(result);

        return result;
    }

    @Scheduled(cron="*/1 * * * * *")
    public int go(){
        return this.count++;
    }

    static class MyTimerTask extends TimerTask{

        private int count;

        public MyTimerTask(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            count++;
        }
    }

    public static void main(String[] args) {

        TimerTask timerTask = new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                String result =   "加载中：" + count++ + "/100";
                System.out.println(result);
            }
        };
        ScheduledExecutorService scheduledExecutorService = newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(timerTask,100,500, TimeUnit.MILLISECONDS);
//        System.out.println(result);
    }
}
