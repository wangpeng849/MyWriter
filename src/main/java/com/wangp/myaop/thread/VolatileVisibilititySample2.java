package com.wangp.myaop.thread;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/2/17 12:49
 */
public class VolatileVisibilititySample2 {


    public static  volatile   int count = 0;

    public static synchronized void compute(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    count++;
                    //第一步 读count的值
                    //第二步 对count进行加一
                    //volatile 并不保证原子性
                    //volatile 如何保证原子性？
                    //
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(count);
    }
}
