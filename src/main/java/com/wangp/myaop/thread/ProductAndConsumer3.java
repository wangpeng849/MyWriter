package com.wangp.myaop.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author farling
 * @Date 2019/12/11
 *
 *
 *  阻塞队列
 */
public class ProductAndConsumer3 {

    private static LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<>(10);

    public static void main(String[] args) {
        new Thread(new Product()).start();
        new Thread(new Consumer()).start();
    }

    static class Product implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(400);
                    list.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "生产者生产：" + list.size());
            }

        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    list.take();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "消费者 消费：" + list.size());
            }

        }

    }
}

