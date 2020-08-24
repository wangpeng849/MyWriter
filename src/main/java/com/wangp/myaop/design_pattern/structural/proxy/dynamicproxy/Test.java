package com.wangp.myaop.design_pattern.structural.proxy.dynamicproxy;

import com.wangp.myaop.design_pattern.structural.proxy.IOrderService;
import com.wangp.myaop.design_pattern.structural.proxy.Order;
import com.wangp.myaop.design_pattern.structural.proxy.OrderServiceImpl;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/24 23:19
 **/
public class Test {

    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(1);
        IOrderService proxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        proxy.saveOrder(order);
    }
}
