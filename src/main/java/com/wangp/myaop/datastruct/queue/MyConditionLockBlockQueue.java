package com.wangp.myaop.datastruct.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 * classname MyBlockQueue
 * description
 * </pre>
 *
 * @author wangpeng 拆分条件
 * @date 2021/3/1 14:57
 **/
public class MyConditionLockBlockQueue extends MyQueue {

    /*** 显示锁 */
    private final ReentrantLock lock = new ReentrantLock();
    /*** 队列未满条件变量 */
    private final Condition notFull = lock.newCondition();
    /*** 队列非空条件变量 */
    private final Condition notEmpty = lock.newCondition();

    /**
     * 初始化
     *
     * @param capacity
     */
    public MyConditionLockBlockQueue(int capacity) {
        this(capacity, false);
    }

    /**
     * 初始化
     *
     * @param capacity
     */
    public MyConditionLockBlockQueue(int capacity, boolean isPrint) {
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
                notFull.await();
            }
            enqueue(e);
            // 唤醒休眠线程
            notEmpty.signal();
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
                notEmpty.await();
            }
            Object e = dequeue();
            // 唤醒其他线程
            notFull.signal();
            return e;
        } finally {
            lock.unlock();
        }

    }
}
