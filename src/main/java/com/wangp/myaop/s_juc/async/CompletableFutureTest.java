package com.wangp.myaop.s_juc.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.util.StopWatch;

/**
 * <pre>
 * classname CompleteFutureTest
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/9/25 17:41
 **/
public class CompletableFutureTest {

    public static String doSomething() throws InterruptedException {
        Thread.sleep(2000);
        return "";
    }

    public static void asyncDoSomething() {
        CompletableFuture<String> completeFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return doSomething();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "";
        });
    }


    public void normal() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 5; i++) {
            doSomething();
        }
        stopWatch.stop();
        stopWatch.prettyPrint();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFutureOne = new CompletableFuture<>();

        ExecutorService cachePool = Executors.newCachedThreadPool();
        cachePool.execute(() -> {
            try {
                Thread.sleep(3000);
                completableFutureOne.complete("异步任务执行结果");
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // WhenComplete 方法返回的 CompletableFuture 仍然是原来的 CompletableFuture 计算结果.
        CompletableFuture<String> completableFutureTwo = completableFutureOne.whenComplete((s, throwable) -> {
            System.out.println("当异步任务执行完毕时打印异步任务的执行结果: " + s);
        });

        // ThenApply 方法返回的是一个新的 completeFuture.
        CompletableFuture<Integer> completableFutureThree = completableFutureTwo.thenApply(s -> {
            System.out.println("当异步任务执行结束时, 根据上一次的异步任务结果, 继续开始一个新的异步任务!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s.length();
        });

        System.out.println("阻塞方式获取执行结果:" + completableFutureThree.get());

        cachePool.shutdown();
    }
}
