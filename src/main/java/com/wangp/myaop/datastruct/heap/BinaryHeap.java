package com.wangp.myaop.datastruct.heap;

import com.wangp.myaop.datastruct.heap.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/6/2 20:42
 * <p>
 * 二叉堆 (大顶堆)
 */
public class BinaryHeap<E> implements Heap<E>, BinaryTreeInfo {
    private E[] elements;
    private int size;
    private Comparator<E> comparator;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(Comparator comparator) {
        this.comparator = comparator;
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap() {
        this(null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);
    }

    /**
     * 让index元素上滤
     *
     * @param index
     */
    private void siftUp(int index) {
        E element = elements[index];
        while (index > 0) {
            //父节点元素
            int pindex = (index - 1) >> 1;
            E p = elements[pindex];
            if (compare(element, p) <= 0) {
                return;
            }
            //交换 element 和 p
            E tmp = elements[index];
            elements[index] = elements[pindex];
            elements[pindex] = tmp;
            //重新复制index
            index = pindex;
        }
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        return null;
    }


    @Override
    public E replace(E element) {
        return null;
    }

    public int compare(E e1, E e2) {
        return comparator != null ? comparator.compare(e1, e2) :
                ((Comparable<E>) e1).compareTo(e2);
    }

    private void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("heap is empty!");
        }
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        //1.5倍扩容
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must be not empty!");
        }
    }

    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        Integer index = (Integer) node;
        index = index << 1 + 1;
        return index >= size ? null:index;
    }

    @Override
    public Object right(Object node) {
        Integer index = (Integer) node;
        index = index << 1 + 2;
        return index >= size ? null:index;
    }

    @Override
    public Object string(Object node) {
        Integer index = (Integer) node;
        return elements[index];
    }
}
