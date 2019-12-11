package com.wangp.myaop.thread;

/**
 * @Author farling
 * @Date 2019/12/11
 * wait() / notify()方法
 * 当缓冲区已满时，生产者线程停止执行，放弃锁，使自己处于等状态，让其他线程执行；
 * 当缓冲区已空时，消费者线程停止执行，放弃锁，使自己处于等状态，让其他线程执行。
 *
 * 当生产者向缓冲区放入一个产品时，向其他等待的线程发出可执行的通知，同时放弃锁，使自己处于等待状态；
 * 当消费者从缓冲区取出一个产品时，向其他等待的线程发出可执行的通知，同时放弃锁，使自己处于等待状态。
 */
public class ProductAndConsumer {
    private static Integer count = 0;
    private static Object LOCK = new Object();


    public static void main(String[] args) {
        new Thread(new Product()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
    }

    static class Product implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 10) {

                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产者生产：" + count);
                    LOCK.notify();
                }

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
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"消费者 消费：" + count);
                    LOCK.notify();
                }

            }

        }
    }
}
