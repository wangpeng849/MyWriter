package com.wangp.myaop.design_pattern.structural.decorator.v2;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/19 20:53
 **/
public class Test {

    public static void main(String[] args) {
        ABattercake battercake = new Battercake();
        battercake = new EggDecorator(battercake);
        battercake = new EggDecorator(battercake);
        battercake = new SausageDecorator(battercake);
        System.out.println(battercake.getDesc() + "，价格：" + battercake.cost());
    }
}
