package com.wangp.myaop.design_pattern.structural.adapter.classadapter;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/19 22:16
 **/
public class Test {

    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();

    }
}
