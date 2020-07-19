package com.wangp.myaop.s_juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/7/19 10:47
 */
public class ShutdownTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new ShutDownTesk());
        }
        Thread.sleep(1500);
        System.out.println("----------"+executorService.isShutdown()+"-----------");
        executorService.shutdown();
        System.out.println("----------"+executorService.isShutdown()+"-----------");
        System.out.println("----------"+executorService.isTerminated()+"-----------");
        executorService.execute(new ShutDownTesk());
        Thread.sleep(10000);
        System.out.println("----------"+executorService.isTerminated()+"-----------");
    }
}
class ShutDownTesk implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {

        }
    }
}