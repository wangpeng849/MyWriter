package com.wangp.myaop.design_pattern.structural.decorator.v1;

/**
 * <pre>
 * classname BattercakeWithEggSausage
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/19 20:38
 **/
public class BattercakeWithEggSausage extends BattercakeWithEgg {

    @Override
    protected String getDesc() {
        return super.getDesc() + "加香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}
