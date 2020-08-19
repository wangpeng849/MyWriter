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
public class ConcreteTarget implements Target {

    @Override
    public void request() {
        System.out.println("ConcreteTarget目标方法");
    }
}
