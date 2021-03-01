package com.wangp.myaop.datastruct.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 * classname MyBlockQueue
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/1 14:57
 **/
public class MyLockBlockQueue extends MyQueue {

    /*** 显示锁 */
    private final ReentrantLock lock = new ReentrantLock();
    /*** 锁条件变量 */
    private final Condition condition = lock.newCondition();

    /**
     * 初始化
     *
     * @param capacity
     */
    public MyLockBlockQueue(int capacity) {
        this(capacity, false);
    }

    /**
     * 初始化
     *
     * @param capacity
     */
    public MyLockBlockQueue(int capacity, boolean isPrint) {
        super(capacity, isPrint);
    }

    /**
     * 放入一个元素
     *
     * @param e 元素
     * @throws InterruptedException
     */
    @Override
    public void put(Object e) throws InterruptedException {
        // 加锁
        lock.lockInterruptibly();
        try {
            // 队列已满时进入休眠
            // 使用与显式锁对应的条件变量
            while (size == items.length) {
                condition.await();
            }
            enqueue(e);
            // 唤醒休眠线程
            condition.signal();
        } finally {
            lock.unlock();
        }
    }


    /**
     * 取出一个元素
     */
    @Override
    public Object take() throws InterruptedException {
        // 加锁
        lock.lockInterruptibly();
        try {
            while (size == 0) {
                // 队列为空时进入休眠
                // 使用与显式锁对应的条件变量
                condition.await();
            }
            Object e = dequeue();
            // 唤醒其他线程
            condition.signal();
            return e;
        } finally {
            lock.unlock();
        }

    }
}
