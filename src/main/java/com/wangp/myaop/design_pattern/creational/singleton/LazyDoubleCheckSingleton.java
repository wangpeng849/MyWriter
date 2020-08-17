package com.wangp.myaop.design_pattern.creational.singleton;

/**
 * <pre>
 * classname LazyDoubleCheckSingleton
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/16 14:51
 **/
public class LazyDoubleCheckSingleton {

    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazyDoubleCheckSingleton == null) {
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                    //1.给对象分配内存
                    //2.初始化对象
                    //3.设置LazyDoubleCheckSingleton指向分配的内存地址
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
