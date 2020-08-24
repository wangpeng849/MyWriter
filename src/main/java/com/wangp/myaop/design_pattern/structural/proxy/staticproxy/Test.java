package com.wangp.myaop.design_pattern.structural.proxy.staticproxy;

import com.wangp.myaop.design_pattern.structural.proxy.Order;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/24 22:55
 **/
public class Test {

    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);
        OrderServiceStaticProxy proxy = new OrderServiceStaticProxy();
        proxy.saveOrder(order);
    }
}
