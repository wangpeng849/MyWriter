package com.wangp.myaop.sort_algorithm;

/**
 * @Author wangp
 * @Date 2020/5/21
 * @Version 1.0
 */
public class MergeSort<E extends Comparable<E>> extends Sort<E> {

    private E[] leftArray;

    @Override
    protected void sort() {
        leftArray = (E[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    /**
     * 对 [begin,end) 范围内的数据进行归并排序
     *
     * @param begin 开始索引
     * @param end   结束索引
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    /**
     *  归并排序的时间复杂度
     *   sort(begin, mid);  T(n/2)
     *   sort(mid, end);    T(n/2)
     *   merge(begin, mid, end);  O(n)
     *   T(n) = 2 * T (n/2) + O(n)
     *   T(n)/n = T(n/2)/(n/2) + O(1)
     *   令 S(n) = T(n)/n
     *   S(1) = O(1)
     *   S(n) = S(n/2) + O(1) = S(n/4) + O(2) = S(n/8) + O(3) = S(n/2^k) + O(n) = S(1) + O(log n) = O(log n)
     *   T(n) = n * S(n) = O(n * log n)
     */

    /**
     * 将 [begin,mid) 和 [mid,end)合并成一个有序序列
     *
     * @param begin
     * @param mid
     * @param end
     */
    private void merge(int begin, int mid, int end) {
        int li = 0;
        int le = mid - begin;
        int ri = mid;
        int re = end;
        int ai = begin;
        //备份左边数组
        for (int i = li; i < le; i++) {
            leftArray[i] = array[begin + i];
        }
        //归并
        while (li < le) { //如果左边没有结束
//            if (cmp(leftArray[li], array[ri]) <= 0) { //等于号使算法为稳定  或者 使用下面写法
//                array[ai++] = leftArray[li++];
//            } else {
//                array[ai++] = array[ri++];
//            }
            if (ri < re && cmp(array[ri], leftArray[li]) < 0) {
                array[ai++] = array[ri++];
            } else {
                array[ai++] = leftArray[li++];
            }
        }

    }
}
