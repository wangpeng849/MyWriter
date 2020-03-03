package com.wangp.myaop.designpattern.create.gongchang.factorymethod.pizzastore.order;

import com.wangp.myaop.designpattern.create.gongchang.factorymethod.pizzastore.pizza.BJCheesePizza;
import com.wangp.myaop.designpattern.create.gongchang.factorymethod.pizzastore.pizza.BJPepperPizza;
import com.wangp.myaop.designpattern.create.gongchang.factorymethod.pizzastore.pizza.Pizza;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 16:28
 */
public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
