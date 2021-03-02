package com.wangp.myaop.s_jvm.classloader;

/**
 * <pre>
 * classname A
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/2 9:30
 **/
public class A {

    public A() {
        System.out.println("A 是被" + this.getClass().getClassLoader() + "加载的");
    }
}
