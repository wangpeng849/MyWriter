package com.wangp.myaop.aop;

import com.wangp.myaop.util.FontTransUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author wangp
 * @Date 2020/5/15
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class FontTransferAspect {

    @Pointcut("@annotation(com.wangp.myaop.aop.FontTransfer)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
        try {
            Object proceed = joinPoint.proceed();
            if(proceed instanceof String){
                proceed = FontTransUtils.simple2Complex((String) proceed);
                return proceed;
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
