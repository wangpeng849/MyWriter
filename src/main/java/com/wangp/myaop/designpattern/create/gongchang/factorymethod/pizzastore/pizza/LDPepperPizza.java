package com.wangp.myaop.designpattern.create.gongchang.factorymethod.pizzastore.pizza;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 16:19
 */
public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦胡椒");
        System.out.println("准备 伦敦胡椒 披萨");
    }
}
