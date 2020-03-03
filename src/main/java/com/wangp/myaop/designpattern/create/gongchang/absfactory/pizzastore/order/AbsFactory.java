package com.wangp.myaop.designpattern.create.gongchang.absfactory.pizzastore.order;

import com.wangp.myaop.designpattern.create.gongchang.absfactory.pizzastore.pizza.Pizza;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 16:42
 */
public interface AbsFactory {
    //让工厂子类实现
    public Pizza createPizza(String orderType);
}
