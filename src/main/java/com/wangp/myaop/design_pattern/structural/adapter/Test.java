package com.wangp.myaop.design_pattern.structural.adapter;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/19 22:37
 **/
public class Test {

    public static void main(String[] args) {
        DC5 dc5 = new PowerAdater();
        dc5.output5V();
    }
}
