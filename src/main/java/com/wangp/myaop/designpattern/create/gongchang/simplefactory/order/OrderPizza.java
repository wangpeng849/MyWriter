package com.wangp.myaop.designpattern.create.gongchang.simplefactory.order;

import com.wangp.myaop.designpattern.create.gongchang.simplefactory.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 15:46
 */
public class OrderPizza {
//    public OrderPizza() {
//        Pizza pizza = null;
//        String orderType = "greek";
//        do{
//            orderType = getType();
//            if(orderType.equals("greek")) {
//                pizza = new GreekPizza();
//                pizza.setName("greek");
//            }else if(orderType.equals("cheese")){
//                pizza = new CheesePizza();
//                pizza.setName("cheese");
//            }else{
//                break;
//            }
//            //输出pizza制作过程
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//        }while (true);
//    }

    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public OrderPizza(SimpleFactory simpleFactory){
        setSimpleFactory(simpleFactory);
    }

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        String orderType = "";
        this.simpleFactory = simpleFactory;
        do {
            orderType = getType();
            pizza = simpleFactory.createPizza(orderType);
            //输出
            if(pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购失败！");
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
