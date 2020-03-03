package com.wangp.myaop.designpattern.create.gongchang.simplefactory;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 15:45
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给奶酪披萨准备原材料");
    }
}
