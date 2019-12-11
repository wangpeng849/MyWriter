package com.wangp.myaop.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author farling
 * @Date 2019/12/11
 *  *  await() / signal()方法
 *  * 在JDK5中，用ReentrantLock和Condition可以实现等待/通知模型，具有更大的灵活性。
 *  * 通过在Lock对象上调用newCondition()方法，将条件变量和一个锁对象进行绑定，进而控制并发程序访问竞争资源的安全
 */
public class ProductAndConsumer2 {
    private static Integer count = 0;
    private static Lock lock = new ReentrantLock();
    private static Condition full = lock.newCondition();
    private static Condition empty = lock.newCondition();

    public static void main(String[] args) {
        new Thread(new Product()).start();
        new Thread(new Consumer()).start();
    }

    static class Product implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (count == 10) {
                    try {
                        full.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println(Thread.currentThread().getName() + "生产者生产：" + count);
                empty.signal();
                lock.unlock();
            }

        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                while (count == 0) {
                    try {
                        empty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println(Thread.currentThread().getName() + "消费者 消费：" + count);
                full.signal();
                lock.unlock();
            }

        }

    }
}

