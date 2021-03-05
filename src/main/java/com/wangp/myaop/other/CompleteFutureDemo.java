package com.wangp.myaop.other;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <pre>
 * classname CompleteFutureDemo
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/4 15:28
 **/
public class CompleteFutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("waiting ok....");
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ok";
        }).thenAccept(System.out::println);
        System.out.println("When not ok!");
        /*****  anyOf  **/
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture
                .anyOf(CompletableFuture.runAsync(CompleteFutureDemo::fun1),
                        CompletableFuture.runAsync(CompleteFutureDemo::fun2));
        System.out.println(objectCompletableFuture.get());
        Thread.currentThread().join();
    }

    public static void fun1() {
        try {
            System.out.println("fun1 start");
            Thread.sleep(1000L);
            System.out.println("fun1 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void fun2() {
        try {
            System.out.println("fun2 start");
            Thread.sleep(1000L);
            System.out.println("fun2 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
