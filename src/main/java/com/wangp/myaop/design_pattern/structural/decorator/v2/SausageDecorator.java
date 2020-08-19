package com.wangp.myaop.design_pattern.structural.decorator.v2;

/**
 * <pre>
 * classname SausageDecorator
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/19 20:50
 **/
public class SausageDecorator extends AbstractDecorator {

    public SausageDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + "加一根香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}
