package com.wangp.myaop.datastruct.heap;

import com.wangp.myaop.datastruct.heap.printer.BinaryTrees;
import io.swagger.models.auth.In;

import java.util.Comparator;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/6/2 22:53
 */
public class Main {

    public static void main(String[] args) {
        test4();
    }

    public static void test2() {
        Integer[] data = {23, 65, 34, 67, 45, 99, 56, 90, 11, 28, 78};
        BinaryHeap<Integer> heap = new BinaryHeap<>(data);
        BinaryTrees.println(heap);
    }

    /**
     * 最小堆
     */
    public static void test3() {
        Integer[] data = {23, 65, 34, 67, 45, 99, 56, 90, 11, 28, 78};
        BinaryHeap<Integer> heap = new BinaryHeap<>(data, (Comparator<Integer>) (o1, o2) -> o2 - o1);
        BinaryTrees.println(heap);
    }

    static void test1() {
        BinaryHeap<Integer> heap = new BinaryHeap();
        heap.add(68);
        heap.add(72);
        heap.add(43);
        heap.add(50);
        heap.add(38);
        heap.add(10);
        heap.add(90);
        heap.add(65);
        BinaryTrees.println(heap);
        heap.replace(88);
        BinaryTrees.println(heap);
    }

    //Top K 问题
    static void test4() {
        Integer[] data = {23, 65, 34, 67, 45, 99, 56, 90, 11, 28, 78, 57, 82, 76, 66, 56, 79, 49, 67,
                45, 68, 80, 34, 9, 78, 79, 34, 23, 57, 79, 34, 78, 70, 57, 40, 68, 12, 58, 45,
                37, 95, 35, 98, 28, 17, 95, 73, 74, 65, 96};
        //新建小顶堆
        BinaryHeap<Integer> heap = new BinaryHeap<>((Comparator<Integer>) (o1, o2) -> o2 - o1);
        //前k个数
        int k = 3;
        for (int i = 0; i < data.length; i++) {
            if (heap.size < k) {  //前k个数添加到小顶堆
                heap.add(data[i]);
            } else if (data[i] > heap.get()) {
                heap.replace(data[i]);

            }
        }
        BinaryTrees.println(heap);
    }
}
