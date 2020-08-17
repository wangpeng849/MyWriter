package com.wangp.myaop.design_pattern.creational.singleton;

/**
 * <pre>
 * classname StaticInnerClassSingleton
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/16 15:01
 **/
public class StaticInnerClassSingleton {

    private static class InnerClass {

        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }

    private StaticInnerClassSingleton() {
        if (InnerClass.staticInnerClassSingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

}
