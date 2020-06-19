package com.wangp.myaop.s_jvm.ch04;

/**
 * @Author wangp
 * @Date 2020/6/18
 * @Version 1.0
 */
public class ShowByteCode {
    // JVM的指令都只有一个字节
    private String xx;

    private final static int TEST = 1;

    public int calc() {
        int a = 100;
        int b = 200;
        int c = 300;
        return (a + b) * c;
    }
}
