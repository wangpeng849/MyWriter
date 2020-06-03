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
public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(Comparator comparator) {
        super(comparator);
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap() {
        this(null, null);
    }

    public BinaryHeap(E[] elements, Comparator comparator) {
        super(comparator);
        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            size = elements.length;
            int capacity = Math.max(elements.length,DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }
    }

    public BinaryHeap(E[] elements) {
        this(elements, null);
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
//        E element = elements[index];
//        while (index > 0) {
//            //父节点元素
//            int pindex = (index - 1) >> 1;
//            E p = elements[pindex];
//            if (compare(element, p) <= 0) {
//                return;
//            }
//            //交换 element 和 p
//            E tmp = elements[index];
//            elements[index] = elements[pindex];
//            elements[pindex] = tmp;
//            //重新复制index
//            index = pindex;
//        }
        E element = elements[index];
        while (index > 0) {
            //父节点元素
            int pindex = (index - 1) >> 1;
            E p = elements[pindex];
            if (compare(element, p) <= 0) {
                break;
            }
            //将父元素存储在index
            elements[index] = p;
            //重新复制index
            index = pindex;
        }
        elements[index] = element;
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        emptyCheck();
        //将0位置备份 并覆盖
        E root = elements[0];
        int lastIndex = --size;
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        siftDown(0);
        return root;
    }

    /**
     * 下滤
     *
     * @param index
     */
    private void siftDown(int index) {
        E element = elements[index];
        int half = size >> 1;
        //index非叶子节点  第一个叶子节点的位置==非叶子节点的数量
        while (index < half) {
            //默认左子节点 作比较
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];
            //右子节点
            int rightIndex = childIndex + 1;
            //选出左右子节点最大的节点
            if (rightIndex < size && compare(elements[rightIndex], child) > 0) {
                child = elements[childIndex = rightIndex];
            }
            if (compare(element, child) >= 0) break;
            //将子节点存放到index位置
            elements[index] = child;
            //重新设置index
            index = childIndex;
        }
        elements[index] = element;
    }

    @Override
    public E replace(E element) {
        elementNotNullCheck(element);
        E root = null;
        if (size == 0) {
            elements[0] = element;
            size++;
        } else {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }
        return root;
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

    private void heapify(){
        //自上而下的上滤
//        for (int i = 0; i < size; i++) {
//            siftUp(i);
//        }
        //自下而上的下滤
        for (int i = (size >> 1) -1; i >=0; i--) {
            siftDown(i);
        }
    }

    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        int index = ((int)node << 1) + 1;
        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        int index = ((int)node << 1) + 2;
        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {
        return elements[(int)node];
    }
}
