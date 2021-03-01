package com.wangp.myaop.datastruct.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * classname QueueTestUtil
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/1 15:28
 **/
public class QueueTestUtil {

    static void testFIFO(MyQueue queue) throws Exception {
        for (int i = 0; i < 10; i++) {
            queue.put(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.take());
        }
        for (int i = 0; i < 5; i++) {
            queue.put(10 + i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.take());
        }
    }


    static void producerAndConsumer(MyQueue myBlockQueue) throws InterruptedException {
        // 默认为 线程2，循环10次
        producerAndConsumerWithParam(myBlockQueue, 2, 10);
    }

    /**
     * @param myBlockQueue 队列
     * @param threads      线程数
     * @param times        每个线程执行次数
     */
    static void producerAndConsumerWithParam(MyQueue myBlockQueue, int threads, int times) throws InterruptedException {
        // 线程列表
        List<Thread> threadList = new ArrayList<>();
        // 开始时间
        long startTime = System.currentTimeMillis();

        // 创建生产者
        for (int i = 0; i < threads; i++) {
            final int offset = i * times;
            // 生产者
            Thread producer = new Thread(() -> {
                try {
                    for (int j = 0; j < times; j++) {
                        // 添加元素
                        myBlockQueue.put(offset + j);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            threadList.add(producer);
            producer.start();
        }
        // 创建消费者
        for (int i = 0; i < threads; i++) {
            // 生产者
            Thread consumer = new Thread(() -> {
                try {
                    for (int j = 0; j < times; j++) {
                        // 取出元素
                        System.out.println(myBlockQueue.take());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            threadList.add(consumer);
            consumer.start();
        }
        // 等待线程执行完
        for (Thread thread : threadList) {
            thread.join();
        }
        // 结束时间
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("总耗时：%.3fs", (endTime - startTime) / 1e3));
    }
}
