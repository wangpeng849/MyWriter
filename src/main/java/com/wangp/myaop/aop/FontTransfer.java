package com.wangp.myaop.aop;

import java.lang.annotation.*;

/**
 * @Author wangp
 * @Date 2020/5/15
 * @Version 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FontTransfer {
}
