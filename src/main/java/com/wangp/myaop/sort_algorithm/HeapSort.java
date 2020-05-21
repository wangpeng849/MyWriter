package com.wangp.myaop.sort_algorithm;

/**
 * @Author wangp
 * @Date 2020/5/20
 * @Version 1.0
 */
//堆排序可以看做是选择排序的优化版
public class HeapSort<E  extends Comparable<E>> extends Sort<E> {
    private int heapSize;

    @Override
    protected void sort() {
        heapSize = array.length;
        //原地建堆
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            shiftDown(i);
        }

        while (heapSize > 1) {
            //交换对顶元素尾部元素
            //0为堆顶   堆尾是heapSize-1
            swap(0, --heapSize);
            //对0位置shiftDown
            shiftDown(0);
        }
    }

    private void shiftDown(int index) {
        E element = array[index];
        int half = heapSize >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            E child = array[childIndex];

            int rightIndex = childIndex + 1;
            if (rightIndex < heapSize && cmp(array[rightIndex], child) > 0) {
                child = array[childIndex = rightIndex];
            }

            if (cmp(element, child) >= 0) break;
            array[index] = child;
            index = childIndex;
        }
        array[index] = element;
    }
}
