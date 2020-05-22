package com.wangp.myaop.sort_algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author wangp
 * @Date 2020/5/22
 * @Version 1.0
 */
public class QuickSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        sort(0, array.length);
    }

    /**
     * 对 [begin,end)范围内做快速排序
     *
     * @param begin 索引
     * @param end   索引
     */
    private void sort(int begin, int end) {  //T(n)
        if (end - begin < 2) return;
        //确定轴点位置  O(n)
        int mid = pivotIndex(begin, end);
        //对子数组排序
        sort(begin, mid);   //T(n/2)   最坏情况 T(n-1)
        sort(mid + 1, end); //T(n/2)   最坏情况 0      ---> T(n) = T(n-1) + O(n) = O(n^2)
        // T(n) = 2*T(n/2) + O(n) --> O(n * log n)   //见归并推导公式
    }

    /**
     * 构造 [begin,end)轴点位置
     *
     * @param begin
     * @param end
     * @return 轴点元素的最终位置
     */
    private int pivotIndex(int begin, int end) {
        //随机选择轴点
        swap(begin, begin + (int) (Math.random() * (end - begin)));
        //备份begin位置
        E pivot = array[begin];
        //end指向最后一个元素
        end--;

        while (begin < end) {
            while (begin < end) {
                //右边元素大于轴点元素
                if (cmp(pivot, array[end]) < 0) {
                    end--;
                }
                //右边元素小于轴点元素
                else {
                    array[begin++] = array[end];
                    break;
                }
            }

            while (begin < end) {
                //左边元素小于轴点元素
                if (cmp(pivot, array[begin]) > 0) {
                    begin++;
                } else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        //将轴点元素放入最终位置
        array[begin] = pivot;
        //轴点元素的位置
        return begin;
    }
}
