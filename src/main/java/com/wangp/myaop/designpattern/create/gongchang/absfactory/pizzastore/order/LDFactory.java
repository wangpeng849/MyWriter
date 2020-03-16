package com.wangp.myaop.designpattern.create.gongchang.absfactory.pizzastore.order;

import com.wangp.myaop.designpattern.create.gongchang.absfactory.pizzastore.pizza.*;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 16:44
 */
public class LDFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
