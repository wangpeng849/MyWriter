package com.wangp.myaop.designpattern.create.gongchang.absfactory.pizzastore.pizza;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 16:19
 */
public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京胡椒");
        System.out.println("准备 北京胡椒 披萨");
    }
}
