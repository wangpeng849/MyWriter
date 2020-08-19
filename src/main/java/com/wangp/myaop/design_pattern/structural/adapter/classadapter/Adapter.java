package com.wangp.myaop.design_pattern.structural.adapter.classadapter;

/**
 * <pre>
 * classname ConcreteTarget
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/19 22:14
 **/
public class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        super.adapteeRequest();
    }
}
