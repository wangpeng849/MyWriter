package com.wangp.myaop.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * classname RepeatRequestInterception
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/10/20 19:56
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatRequestInterception {

    /**
     * 重复请求拦截（默认拦截）
     */
    boolean isInterception() default true;

    /**
     * 拦截时间（默认60秒）
     */
    long durationTime() default 60;
}
