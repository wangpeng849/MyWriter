package com.wangp.myaop.other;

import java.util.concurrent.Semaphore;
import lombok.SneakyThrows;

/**
 * <pre>
 * classname SemaphoreDemo
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/2 15:26
 **/
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Test test = new Test(semaphore);
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        System.out.println("end");
    }

    static class Test implements Runnable {

        private final Semaphore semaphore;

        public Test(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @SneakyThrows
        @Override
        public void run() {
            semaphore.acquire();
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + " run ..");
            semaphore.release();
        }
    }
}
