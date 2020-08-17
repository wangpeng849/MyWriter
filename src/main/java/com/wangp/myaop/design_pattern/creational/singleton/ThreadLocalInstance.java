package com.wangp.myaop.design_pattern.creational.singleton;

/**
 * <pre>
 * classname ThreadLocalInstance
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/17 17:55
 **/
public class ThreadLocalInstance {

    private static ThreadLocal<ThreadLocalInstance> threadLocalInstanceThreadLocal = ThreadLocal
            .withInitial(() -> new ThreadLocalInstance());

    private ThreadLocalInstance() {
    }

    public static ThreadLocalInstance getInstance() {
        return threadLocalInstanceThreadLocal.get();
    }
}
