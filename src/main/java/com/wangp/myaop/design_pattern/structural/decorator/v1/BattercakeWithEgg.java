package com.wangp.myaop.design_pattern.structural.decorator.v1;

/**
 * <pre>
 * classname BattercakeWithEgg
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/19 20:37
 **/
public class BattercakeWithEgg extends Battercake {

    @Override
    protected String getDesc() {
        return super.getDesc() + "加个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 1;
    }
}
