package com.wangp.myaop.datastruct.queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 * classname MyBlockQueue
 * description
 * </pre>
 *
 * @author wangpeng 拆分锁
 * @date 2021/3/1 14:57
 **/
public class MySplitLockBlockQueue extends MyQueue {

    /*** 插入锁 */
    private final ReentrantLock putLock = new ReentrantLock();
    /*** 弹出锁 */
    private final ReentrantLock takeLock = new ReentrantLock();
    /*** 队列未满条件变量 */
    private final Condition notFull = putLock.newCondition();
    /*** 队列非空条件变量 */
    private final Condition notEmpty = takeLock.newCondition();

    /*** 为了不影响其他地方使用 size 新定义一个size **/
    private final AtomicInteger size = new AtomicInteger(0);

    /**
     * 初始化
     *
     * @param capacity
     */
    public MySplitLockBlockQueue(int capacity) {
        this(capacity, false);
    }

    /**
     * 初始化
     *
     * @param capacity
     */
    public MySplitLockBlockQueue(int capacity, boolean isPrint) {
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
        putLock.lockInterruptibly();
        try {
            while (size.get() == items.length) {
                // 队列已满时进入休眠
                // 等待队列未满条件得到满足
                notFull.await();
            }
            // 执行入队操作，将对象e实际放入队列中
            enqueue(e);
        } finally {
            putLock.unlock();
        }
        // 唤醒等待队列非空条件的线程
        // 为了防止死锁，不能在释放putLock之前获取takeLock
        signalNotEmpty();
    }


    /**
     * 取出一个元素
     */
    @Override
    public Object take() throws InterruptedException {
        Object e;
        // 加锁
        takeLock.lockInterruptibly();
        try {
            while (size.get() == 0) {
                notEmpty.await();
            }
            e = dequeue();
        } finally {
            takeLock.unlock();
        }
        signalNotFull();
        return e;
    }

    /**
     * <pre>
     * 重写入队和出队方法，
     * 使用 CAS操作 size变量解决 put()和 take()方法的竞争
     * </pre>
     */

    @Override
    protected void enqueue(Object e) {
        if (isPrint) {
            System.out.println(Thread.currentThread().getName() + "：put " + e + " into queue");
        }
        // 将数据放入队列
        items[putIndex] = e;
        // putIndex向后移一位，如果已到末尾则返回队列开头(位置0)
        if (++putIndex == items.length) {
            putIndex = 0;
        }
        // 队列元素加1
        size.getAndIncrement();
    }

    @Override
    protected Object dequeue() {
        // 取出元素
        Object item = items[takeIndex];
        items[takeIndex] = null;
        // 打印
        if (isPrint) {
            System.out.println(Thread.currentThread().getName() + "：take " + item + " out queue");
        }
        // takeIndex，如果已到末尾则返回队列开头(位置0)
        if (++takeIndex == items.length) {
            takeIndex = 0;
        }
        // 队列元素减1
        size.decrementAndGet();
        return item;
    }

    /***
     * 唤醒非空线程
     */
    private void signalNotEmpty() {
        // 获取弹出锁
        takeLock.lock();
        try {
            // 唤醒等待线程
            notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }

    /***
     * 唤醒未满线程
     */
    private void signalNotFull() {
        // 获取插入锁
        putLock.lock();
        try {
            // 唤醒线程
            notFull.signal();
        } finally {
            putLock.unlock();
        }
    }
}
