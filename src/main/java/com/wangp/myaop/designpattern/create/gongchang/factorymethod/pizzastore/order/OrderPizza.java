package com.wangp.myaop.designpattern.create.gongchang.factorymethod.pizzastore.order;

import com.wangp.myaop.designpattern.create.gongchang.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 16:21
 */
public abstract class OrderPizza {
    //让工厂子类自己实现
    abstract Pizza createPizza(String orderType);


    public OrderPizza() {
        Pizza pizza = null;
        String orderType = "";
        do {
            orderType = getType();
            pizza = createPizza(orderType);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }
    public String getType() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = br.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
