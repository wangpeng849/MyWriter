package com.wangp.myaop.design_pattern.creational.singleton;

/**
 * <pre>
 * classname T
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/15 11:29
 **/
public class T implements Runnable {

    @Override
    public void run() {
//        LazySingleton lazySingleton = LazySingleton.getInstance();

//        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();

//        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();

        HungrySingleton instance = HungrySingleton.getInstance();
        
        System.out.println(Thread.currentThread().getName() + ":" + instance);
    }
}
