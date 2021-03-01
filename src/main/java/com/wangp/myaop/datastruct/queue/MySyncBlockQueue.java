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
public class MySyncBlockQueue extends MyQueue {

    /**
     * 初始化
     *
     * @param capacity
     */
    public MySyncBlockQueue(int capacity) {
        this(capacity, false);
    }

    /**
     * 初始化
     *
     * @param capacity
     */
    public MySyncBlockQueue(int capacity, boolean isPrint) {
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
        while (true) {
            // 加锁
            synchronized (this) {
                if (size != items.length) {
                    enqueue(e);
                    break;
                }
            }
            // 休眠
            Thread.sleep(200L);
        }
    }


    /**
     * 取出一个元素
     */
    @Override
    public Object take() throws InterruptedException {
        while (true) {
            // 加锁
            synchronized (this) {
                // 直到队列非空时才继续执行后续的出队操作并返回弹出的元素
                if (size != 0) {
                    // 执行出队操作，将队列中的第一个元素弹出
                    return dequeue();
                }
            }
            // 队列为空的情况下休眠200ms
            Thread.sleep(200L);
        }
    }

}
