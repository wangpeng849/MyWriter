package com.wangp.myaop.springboot;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/2/18 8:58
 *
 *
 *
 * Springboot 热部署五种方式
 *      1.模板热部署
 *      2.使用调式模式debug实现热部署
 *      3.spring-boot-devtools
 *      4.spring Loaded
 *      5.JRebel
 */
public class ReDeployment {
    /**
     *   1. 模板热部署
     *   在springboot中 模板引擎的页面默认是开启缓存的，如果修改了页面内容，则刷新页面是得不到修改后的页面的，
     *   因此我们可以在appliction.properties中关闭模板引擎的焕春，如下：
     *   spring.thymeleaf.cache=false
     */

    /**
     *    2.使用调式模式debug实现热部署
     *    此种方式最简单最快速的一种热部署方式，运行系统时使用debug模式，无需装任何插件即可，但是无法对配置文件。
     *    方法名称改变，增加类及方法进行热部署，使用范围有限
     */

    /**
     *   3.spring-boot-devtools
     *   在sprinbboot项目中添加spring-boot-devtools依赖即可实现页面和代码的热部署，如下：
     *     <dependency>
     *             <groupId>org.springframework.boot</groupId>
     *             <artifactId>spring-boot-devtools</artifactId>
     *      </dependency>
     *
     *      此种方式的特点是作用范围广，系统的任何变动包括配置文件的修改，方法名称变化都能覆盖，但是后遗症也非常明显，
     *      它是采用文件变化后重启的策略来实现了，主要是节约了我们手动点击重启的时间，提高了时效性，在体验上略差。
     *      spring-boot-deltools默认关闭了模板缓存，如果使用这种方式不用单独配置关闭模板缓存。
     */

    /**
     *  4. Spring Loaded
     *  此种方式类似于Debug模式，适用范围有限，但是不依赖于debug模式启动，通过Spring Loaded库文件启动，即可在正常
     *  模式下实现热部署。此种需要在run confrgration中配置
     */

    /**
     *  5. JRebel
     *   JRebel是Java开发最好的热部署工具对Spring Boot 提供了极佳的支持，JRebel为收费软件，试用期14天，可直接通过插件安装
     */
}
