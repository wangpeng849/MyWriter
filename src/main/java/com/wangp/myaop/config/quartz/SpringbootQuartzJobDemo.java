package com.wangp.myaop.config.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * @Author wangp
 * @Date 2020/4/21
 * @Version 1.0
 */
public class SpringbootQuartzJobDemo implements Job {

    @Autowired
    private CommonsUtil4Quartz commonsUtil4Quartz;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("SpringBootQuartzJobDemo : " + LocalDateTime.now());
        this.commonsUtil4Quartz.testMethod();
    }
}
