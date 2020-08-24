package com.wangp.myaop.design_pattern.structural.proxy.dynamicproxy;

import com.wangp.myaop.design_pattern.structural.proxy.Order;
import com.wangp.myaop.design_pattern.structural.proxy.db.DataSourceContextHolder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <pre>
 * classname OrderServiceDynamicProxy
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/24 23:01
 **/
public class OrderServiceDynamicProxy implements InvocationHandler {

    private Object target;

    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    public Object bind() {
        Class<?> aClass = target.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object argument = args[0];
        beforeMethod(argument);
        Object obj = method.invoke(target, args);
        afterMethod();
        return obj;
    }

    private void beforeMethod(Object obj) {
        int userId = 1;
        System.out.println("动态代理 before code");
        if (obj instanceof Order) {
            Order order = (Order) obj;
            userId = order.getUserId();
        }
        int dbRouter = userId & 1;
        System.out.println("动态代理分配到[db " + dbRouter + "]处理数据");
        DataSourceContextHolder.setDBType(dbRouter + "");
    }

    private void afterMethod() {
        System.out.println("动态代理 after code");
    }
}
