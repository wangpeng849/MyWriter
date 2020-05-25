package com.wangp.myaop.sort_algorithm.cmp;

/**
 * @Author wangp
 * @Date 2020/5/21
 * @Version 1.0
 */
public class InsertionSort3<E extends Comparable<E>> extends Sort<E> {
    //使用二分搜索优化
//    @Override
//    protected void sort() {
//        for (int begin = 1; begin < array.length; begin++) {
//            int insertIndex = search(begin);
//            E cnt = array[begin];
//            //将[insertIndex,begin)挪动
//            //for (int i = begin -1; i>=insertIndex; i--) 等同于下面
//            for (int i = begin; i > insertIndex; i--) {
//                array[i] = array[i - 1];
//            }
//            array[insertIndex] = cnt;
//        }
//    }

    //为以上的代码优化
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            insert(begin,search(begin));
        }
    }

    /**
     * 将source元素的位置插入到dest
     * @param source 源
     * @param dest 目标
     */
    private void insert(int source, int dest) {
        E e = array[source];
        for (int i = source; i > dest; i--) {
            array[i] = array[i-1];
        }
        array[dest] = e;
    }

    /**
     * 找到index位置元素的待插入位置
     * 已经排好序的数组的区间[0,index)
     *
     * @param index 索引
     * @return 位置
     */
    private int search(int index) {
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(array[index], array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }


}
