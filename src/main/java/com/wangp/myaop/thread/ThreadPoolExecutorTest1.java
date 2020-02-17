package com.wangp.myaop.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/2/17 14:36
 */
public class ThreadPoolExecutorTest1 {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " is run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(6,10,5, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        //核心线程为6 最大线程数为10 超时时间为5秒

        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        System.out.println("先开3个。。。");
        System.out.println("核心线程数：" + executor.getCorePoolSize());
        System.out.println("线程池数：" + executor.getPoolSize());
        System.out.println("队列任务数：" + executor.getQueue().size());
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        System.out.println("再开6个。。。");
        System.out.println("核心线程数：" + executor.getCorePoolSize());
        System.out.println("线程池数：" + executor.getPoolSize());
        System.out.println("队列任务数：" + executor.getQueue().size());
        Thread.sleep(8000);
        System.out.println("8秒之后。。。");
        System.out.println("核心线程数：" + executor.getCorePoolSize());
        System.out.println("线程池数：" + executor.getPoolSize());
        System.out.println("队列任务数：" + executor.getQueue().size());
    }
}
