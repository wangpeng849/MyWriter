package com.wangp.myaop.thread;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/2/17 12:49
 */
public class VolatileVisibilititySample {
    /**
     *   此处加不加volatile将决定是否死循环
     */
    public static  boolean initFlag = false;

    public static void loadData() {
        while (!initFlag) {

        }
        System.out.println("find initFlag is change!");
    }

    public static void refresh() {
        System.out.println("loadDate....");
        System.out.println("change initFlag start ...");
        initFlag = true;
        System.out.println("channge initFlag end...");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(() -> {
            loadData();
        }, "threadA");
        A.start();
        Thread.sleep(500);
        Thread B = new Thread(() -> {
            refresh();
        }, "threadB"
        );
        B.start();
    }
}
