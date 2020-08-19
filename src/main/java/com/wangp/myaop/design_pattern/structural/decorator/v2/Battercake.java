package com.wangp.myaop.design_pattern.structural.decorator.v2;

/**
 * <pre>
 * classname Battercake
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/19 20:48
 **/
public class Battercake extends ABattercake {

    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
