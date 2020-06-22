package com.wangp.myaop.s_jvm.ch05.classinit;

/**
 * @Author wangp
 * @Date 2020/6/19
 * @Version 1.0
 */
public class SubClazz extends SuperClazz {
    static{
        System.out.println("SubClass init ");
    }

    public SubClazz(){
        System.out.println("SubClazz Constructor");
    }
}
