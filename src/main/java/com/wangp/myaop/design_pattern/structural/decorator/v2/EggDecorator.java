package com.wangp.myaop.design_pattern.structural.decorator.v2;

/**
 * <pre>
 * classname EggDecorator
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/19 20:52
 **/
public class EggDecorator extends AbstractDecorator {

    public EggDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + "加个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 1;
    }
}
