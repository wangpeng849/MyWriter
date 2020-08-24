package com.wangp.myaop.design_pattern.structural.proxy.staticproxy;

import com.wangp.myaop.design_pattern.structural.proxy.IOrderService;
import com.wangp.myaop.design_pattern.structural.proxy.Order;
import com.wangp.myaop.design_pattern.structural.proxy.OrderServiceImpl;
import com.wangp.myaop.design_pattern.structural.proxy.db.DataSourceContextHolder;

/**
 * <pre>
 * classname OrderServiceStaticProxy
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/24 22:44
 **/
public class OrderServiceStaticProxy {

    private IOrderService iOrderService;

    public int saveOrder(Order order) {
        beforeMethod(order);
        int result = iOrderService.saveOrder(order);
        afterMethod();
        return result;
    }

    private void beforeMethod(Order order) {
        System.out.println("静态代理 before code");
        iOrderService = new OrderServiceImpl();
        Integer userId = order.getUserId();
        int dbRouter = userId & 1;
        System.out.println("静态代理分配到[db " + dbRouter + "]处理数据");
        DataSourceContextHolder.setDBType(dbRouter + "");
    }

    private void afterMethod() {
        System.out.println("静态代理 after code");
    }
}
