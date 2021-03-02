package com.wangp.myaop.other;

import java.util.concurrent.CountDownLatch;
import lombok.SneakyThrows;

/**
 * <pre>
 * classname CountDownLatchDemo
 * description ⽐如现在要让第5个线程等待前4个线程执⾏完毕再执⾏
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/2 14:24
 **/
public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Test test = new Test(countDownLatch);
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        countDownLatch.await();
        System.out.println("end");
    }
}

class Test implements Runnable {

    private final CountDownLatch countDownLatch;

    public Test(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run...");
        Thread.sleep(1000);
        countDownLatch.countDown();
    }
}
