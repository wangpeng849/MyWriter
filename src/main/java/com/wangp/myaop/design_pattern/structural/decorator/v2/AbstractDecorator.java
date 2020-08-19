package com.wangp.myaop.design_pattern.structural.decorator.v2;

/**
 * <pre>
 * classname AbstractDecorator
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/19 20:49
 **/
public abstract class AbstractDecorator extends ABattercake {

    ABattercake aBattercake;

    public AbstractDecorator(ABattercake aBattercake) {
        this.aBattercake = aBattercake;
    }

//    protected abstract void doSomething();

    @Override
    protected String getDesc() {
        return aBattercake.getDesc();
    }

    @Override
    protected int cost() {
        return aBattercake.cost();
    }
}
