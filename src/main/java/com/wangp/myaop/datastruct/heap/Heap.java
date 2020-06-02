package com.wangp.myaop.datastruct.heap;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/6/2 20:39
 */
public interface Heap<E> {
    int size();//元素数量
    boolean isEmpty();//是否为空
    void clear();//清空
    void add(E element);//添加元素
    E get();//获得堆顶元素
    E remove();//删除堆顶元素
    E replace(E element);//删除堆顶元素同时插入一个元素
}
