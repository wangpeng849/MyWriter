package com.wangp.myaop.config.quartz;

import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

/**
 * @Author wangp
 * @Date 2020/4/21
 * @Version 1.0
 */
@Configuration
public class QuartzConfiguration {

    /**
     * 创建Job对象。在Spring环境中，创建一个类型的对象的时候，很多情况下，都是通过FactoryBean来间接创建的。
     * 如果有多个Job对象，定义多次方法。
     *
     * 在JobDetailFactoryBean类型中，用于创建JobDetail对象的方法，其底层使用的逻辑是：Class.newInstance()
     * 也就是说，JobDetail对象不是通过Spring容器管理的。
     * 因为Spring容器不管理JobDetail对象，那么Job中需要自动装配的属性，就无法实现自动状态。如上JOB的第10行会报空指针异常。
     *
     * 解决方案是： 将JobDetail加入到Spring容器中，让Spring容器管理JobDetail对象。
     * 需要重写Factory相关代码。实现Spring容器管理JobDetail。
     * @return
     */
    @Bean
    public JobDetailFactoryBean initJobDetailFactoryBean(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(SpringbootQuartzJobDemo.class);
        return factoryBean;
    }


}
