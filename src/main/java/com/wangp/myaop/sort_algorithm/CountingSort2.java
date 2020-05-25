package com.wangp.myaop.sort_algorithm;

import com.wangp.myaop.sort_algorithm.cmp.Sort;

/**
 * @Author wangp
 * @Date 2020/5/22
 * @Version 1.0
 */
public class CountingSort2 extends Sort<Integer> {
    /**
     * 计数排序仅仅针对整数
     * <p>
     * 解决以下问题：
     * 1.对负整数排序
     * 2.减少空间浪费
     * 3.稳定的排序
     */
    @Override
    protected void sort() {
        //找出最值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }//O(n)

        //开辟内存空间，存储次数
        int[] counts = new int[max - min + 1];
        //统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i] - min]++;
        }
        //累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i]+=counts[i-1];
        }
        //从后遍历元素，将他放到有序数组合适的位置
        int[] newArray = new int[array.length];
        for (int i = array.length -1; i >= 0; i--) {
//            --counts[array[i] - min];
            newArray[--counts[array[i] - min]] = array[i];
        }
        //将有序数组覆盖array
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }
}
