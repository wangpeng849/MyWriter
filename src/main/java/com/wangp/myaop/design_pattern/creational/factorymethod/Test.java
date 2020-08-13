package com.wangp.myaop.design_pattern.creational.factorymethod;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/12 19:40
 **/
public class Test {

    public static void main(String[] args) {
        VideoFactory factory = new JavaVideoFactory();
        factory.getVideo().produce();
    }
}
