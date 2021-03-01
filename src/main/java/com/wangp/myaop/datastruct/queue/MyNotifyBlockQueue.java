package com.wangp.myaop.datastruct.queue;

/**
 * <pre>
 * classname MyBlockQueue
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/1 14:57
 **/
public class MyNotifyBlockQueue extends MyQueue {


    /**
     * 初始化
     *
     * @param capacity
     */
    public MyNotifyBlockQueue(int capacity) {
        this(capacity, false);
    }

    /**
     * 初始化
     *
     * @param capacity
     */
    public MyNotifyBlockQueue(int capacity, boolean isPrint) {
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
        synchronized (this) {
            // 此处必须用while 不能用if
            while (size == items.length) {
                // 休眠
                this.wait();
            }
            // 添加元素
            enqueue(e);
            // 唤醒
            this.notify();
        }
    }


    /**
     * 取出一个元素
     */
    @Override
    public Object take() throws InterruptedException {
        // 加锁
        synchronized (this) {
            // 直到队列非空时才继续执行后续的出队操作并返回弹出的元素
            while (size == 0) {
                // 队列为空的情况下休眠
                this.wait();
            }
            // 执行出队操作，将队列中的第一个元素弹出
            Object e = dequeue();
            // 唤醒
            this.notify();
            return e;
        }
    }

}
