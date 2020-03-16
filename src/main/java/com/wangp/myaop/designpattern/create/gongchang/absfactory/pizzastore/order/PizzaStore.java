package com.wangp.myaop.designpattern.create.gongchang.absfactory.pizzastore.order;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 16:50
 */
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }
}
