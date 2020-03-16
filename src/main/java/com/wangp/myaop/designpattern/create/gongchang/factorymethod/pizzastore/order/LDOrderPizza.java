package com.wangp.myaop.designpattern.create.gongchang.factorymethod.pizzastore.order;

import com.wangp.myaop.designpattern.create.gongchang.factorymethod.pizzastore.pizza.*;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 16:28
 */
public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
