package com.wangp.myaop.designpattern.create.gongchang.simplefactory.order;

import com.wangp.myaop.designpattern.create.gongchang.simplefactory.CheesePizza;
import com.wangp.myaop.designpattern.create.gongchang.simplefactory.GreekPizza;
import com.wangp.myaop.designpattern.create.gongchang.simplefactory.Pizza;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 16:05
 */
public class SimpleFactory {
    public Pizza createPizza(String orderType){

        Pizza pizza = null;

        System.out.println("使用简单工厂模式");
        if(orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("greek");
        }else if(orderType.equals("cheese")){
            pizza = new CheesePizza();
            pizza.setName("cheese");
        }
        return pizza;
    }
}
