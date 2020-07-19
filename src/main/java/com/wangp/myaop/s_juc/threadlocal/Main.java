package com.wangp.myaop.s_juc.threadlocal;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/7/19 19:32
 */
public class Main {
    //让某个用到的对象在线程间隔离
    //在任何方法中都能后去到这个对象

    //优点：
    // 达到线程安全
    // 不需要加锁，提高效率
    // 高效利用内存
    // 免去传参的繁琐
}
