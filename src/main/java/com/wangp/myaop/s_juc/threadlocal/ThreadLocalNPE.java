package com.wangp.myaop.s_juc.threadlocal;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/7/19 20:08
 */
public class ThreadLocalNPE {

    ThreadLocal<Long> numberThreadLocal = new ThreadLocal<>();

    public void set() {
        numberThreadLocal.set(Thread.currentThread().getId());
    }

    //拆箱导致异常
//    public long get() {
    public Long get() {
        return numberThreadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalNPE threadLocalNPE = new ThreadLocalNPE();
        System.out.println(threadLocalNPE.get());
        Thread subThread = new Thread(() -> {
            threadLocalNPE.set();
            System.out.println(threadLocalNPE.get());
        });
        subThread.start();
    }
}
