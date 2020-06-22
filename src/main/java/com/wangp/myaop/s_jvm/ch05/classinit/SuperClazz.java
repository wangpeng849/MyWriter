package com.wangp.myaop.s_jvm.ch05.classinit;

/**
 * @Author wangp
 * @Date 2020/6/19
 * @Version 1.0
 */
public class SuperClazz {
    static{
        System.out.println("SuperClass init");
    }

    public static int value = 123;
    public static final String HELLO_WORLD = "hello , world";
    public static final int WHAT = value;
    public SuperClazz(){
        System.out.println("SuperClass Constructor");
    }
}
