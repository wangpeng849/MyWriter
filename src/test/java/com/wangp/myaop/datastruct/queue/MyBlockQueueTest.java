package com.wangp.myaop.datastruct.queue;

import org.junit.jupiter.api.Test;

class MyBlockQueueTest {

    @Test
    void test() throws Exception {
        // 会出现异常，或者取出null值
//        QueueTestUtil.producerAndConsumer(new MyBlockQueue(2));
        // 由于加锁耗时比较长
//        QueueTestUtil.producerAndConsumer(new MySyncBlockQueue(2));
//        QueueTestUtil.producerAndConsumer(new MyNotifyBlockQueue(2));
//        QueueTestUtil.producerAndConsumer(new MyLockBlockQueue(2));
        // 耗时最久
//        QueueTestUtil.producerAndConsumerWithParam(new MyLockBlockQueue(2), 400, 100);
        // 耗时 5 秒
//        QueueTestUtil.producerAndConsumerWithParam(new MyConditionLockBlockQueue(2), 500, 1000);
        // 耗时 4.7秒
//        QueueTestUtil.producerAndConsumerWithParam(new MySplitLockBlockQueue(2), 500, 1000);
        // 耗时 3.5秒
        QueueTestUtil.producerAndConsumerWithParam(new MySplitLockImproveBlockQueue(2), 500, 1000);
    }

    @Test
    public void testFIFO() throws Exception {
        QueueTestUtil.testFIFO(new MyBlockQueue(10));
        System.out.println("--------------------------------------");
        QueueTestUtil.testFIFO(new MySyncBlockQueue(10));
        System.out.println("--------------------------------------");
        QueueTestUtil.testFIFO(new MyNotifyBlockQueue(10));
        System.out.println("--------------------------------------");
        QueueTestUtil.testFIFO(new MyLockBlockQueue(10));

    }
}