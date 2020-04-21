package com.wangp.myaop.config.schedule;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * @Author wangp
 * @Date 2020/4/21
 * @Version 1.0
 */
@Configuration
@EnableScheduling
public class DynamicScheduleTask implements SchedulingConfigurer {

    @Mapper
    public interface CronMapper {
        @Select("select cron from cron limit 1")
        String getCron();
    }

    @Autowired
    private CronMapper cronMapper;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.addTriggerTask(
//                //1.添加任务内容
//                () -> System.out.println("执行动态任务 -》" + LocalDateTime.now()),
//                //2.设置周期
//                triggerContext -> {
//                    //2.1从数据库拿周期
//                    String cron = cronMapper.getCron();
//                    //2.2合法性检测
//                    if (StringUtils.isEmpty(cron)) {
//                        System.out.println("周期有问题");
//                    }
//                    //2.3 返回执行周期
//                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
//                }
//        );
    }
}
