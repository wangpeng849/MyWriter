package com.wangp.myaop.designpattern.create.gongchang.absfactory.pizzastore.order;

import com.wangp.myaop.designpattern.create.gongchang.absfactory.pizzastore.pizza.Pizza;
import com.wangp.myaop.designpattern.create.gongchang.absfactory.pizzastore.pizza.BJCheesePizza;
import com.wangp.myaop.designpattern.create.gongchang.absfactory.pizzastore.pizza.BJPepperPizza;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 16:44
 */
public class BJFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
