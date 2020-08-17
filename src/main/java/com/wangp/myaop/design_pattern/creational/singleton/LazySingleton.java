package com.wangp.myaop.design_pattern.creational.singleton;

/**
 * <pre>
 * classname LazySingleton
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/15 11:23
 * <p>
 * 懒汉无法抵御反射
 **/
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
        if (lazySingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public synchronized static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
