package com.wangp.myaop.design_pattern.structural.adapter.objectadapter;

/**
 * <pre>
 * classname ConcreteTarget
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/19 22:14
 **/
public class Adapter implements Target {

    Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
