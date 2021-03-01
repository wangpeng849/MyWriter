package com.wangp.myaop.datastruct.queue;

/**
 * <pre>
 * classname MyQueue
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/1 15:29
 **/
public abstract class MyQueue {

    protected final Object[] items;
    protected final boolean isPrint;
    protected int putIndex;
    protected int takeIndex;
    protected int size;

    public MyQueue(int capacity) {
        this(capacity, false);
    }

    public MyQueue(int capacity, boolean isPrint) {
        items = new Object[capacity];
        this.isPrint = isPrint;
    }

    abstract void put(Object e) throws Exception;

    abstract Object take() throws Exception;

    /**
     * 加入队列
     *
     * @param e 元素
     */
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
        size++;
    }

    /**
     * 取出一个元素
     */
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
        size--;
        return item;
    }
}
