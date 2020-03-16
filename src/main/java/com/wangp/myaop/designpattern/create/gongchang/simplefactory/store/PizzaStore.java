package com.wangp.myaop.designpattern.create.gongchang.simplefactory.store;

import com.wangp.myaop.designpattern.create.gongchang.simplefactory.order.OrderPizza;
import com.wangp.myaop.designpattern.create.gongchang.simplefactory.order.SimpleFactory;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 15:53
 */
//相当于客户端 发出订购
public class PizzaStore {
    public static void main(String[] args) {
//        OrderPizza pizza = new OrderPizza();
        new OrderPizza(new SimpleFactory());
        System.out.println("退出程序~");
    }
}
