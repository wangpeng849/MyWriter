package com.wangp.myaop.stream;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * classname ParallelStreamDemo
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/10/16 15:40
 **/
public class ParallelStreamDemo {

    public static void streamTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.parallelStream().forEach(num -> {
            System.out.println("第一个并行流");
            System.out.println(Thread.currentThread().getName() + ">>" + num);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static void streamTest2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.parallelStream().forEach(num -> {
            System.out.println("第二个并行流");
            System.out.println(Thread.currentThread().getName() + ">>" + num);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> streamTest());
        Thread thread2 = new Thread(() -> streamTest2());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
