package com.wangp.myaop.s_jvm.classloader;

/**
 * <pre>
 * classname TestMain
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/2 9:31
 **/
public class TestMain {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("TestMain是被" + TestMain.class.getClassLoader() + "加载的");
    }
}
