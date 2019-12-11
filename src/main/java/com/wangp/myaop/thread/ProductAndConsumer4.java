package com.wangp.myaop.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author farling
 * @Date 2019/12/11
 *
 * Semaphore
 */
public class ProductAndConsumer4 {
    private static Integer count = 0;
    static Semaphore notFull = new Semaphore(10);
    static Semaphore notEmpty = new Semaphore(0);
//    static Semaphore mutex = new Semaphore(1);

    public static void main(String[] args) {
        new Thread(new Product()).start();
        new Thread(new Consumer()).start();
    }

    static class Product implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    notFull.acquire();
                    Thread.sleep(500);
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产：" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
//                    mutex.release();
                    notEmpty.release();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    notEmpty.acquire();
                    Thread.sleep(500);
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者 消费：" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
//                    mutex.release();
                    notFull.release();
                }

            }
        }

    }
}

