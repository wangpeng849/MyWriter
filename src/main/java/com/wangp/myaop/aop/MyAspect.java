package com.wangp.myaop.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class MyAspect {

    /**
     * 抽取公共的切入点表达式
     * 1.本类的引用
     * 2.其他的切面引用
     */
//    @Pointcut("execution(* com.wangp.myaop.controller.MyController.*(..))")
    @Pointcut("@annotation(com.wangp.myaop.aop.Entity)")
    public void myPointCut(){}

    @Before("myPointCut()")
    public void funStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("" + joinPoint.getSignature().getName() + " funStart..." + Arrays.asList(args));
    }

    @After("myPointCut()")
    public void funEnd(JoinPoint joinPoint){
        System.out.println("  funEnd... ");
    }


    @AfterReturning(value = "myPointCut()",returning = "result")
    public void funReturn(Object result){
        System.out.println("  funReturn...");
    }

    @AfterThrowing(value = "myPointCut()", throwing = "exception")
    public void logThrown(Exception exception) {
        System.out.println("funThrown...");
    }

    @Around(value = "myPointCut()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object target = proceedingJoinPoint
                .getTarget()
                .getClass()
                .getName();
        System.out.println("調用者："+target);
        List<Object> args = Arrays.asList(proceedingJoinPoint.getArgs());
        System.out.println("运行...参数列表是:{" + args + "}");
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        return method.invoke(Class.forName(target.toString()).newInstance(),"brithday:"+args.get(0).toString());
    }
}
