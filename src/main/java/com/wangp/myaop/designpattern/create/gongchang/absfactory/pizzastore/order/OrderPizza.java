package com.wangp.myaop.designpattern.create.gongchang.absfactory.pizzastore.order;

import com.wangp.myaop.designpattern.create.gongchang.absfactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 16:46
 */
public class OrderPizza {
    AbsFactory factory;

    public OrderPizza(AbsFactory factory){
        setFactory(factory);
    }

    public void setFactory(AbsFactory factory) {
        this.factory = factory;
        Pizza pizza = null;
        String orderType = "";

        do {
            orderType = getType();
            pizza = factory.createPizza(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败");
                break;
            }
        } while (true);

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
