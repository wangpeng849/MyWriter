package com.wangp.myaop.sort_algorithm;

import com.wangp.myaop.sort_algorithm.cmp.Sort;

/**
 * @Author wangp
 * @Date 2020/5/22
 * @Version 1.0
 */
public class CountingSort extends Sort<Integer> {
    /**
     * 计数排序仅仅针对整数
     * <p>
     * 以下存在问题：
     * 1.无法对负整数排序
     * 2.及其浪费空间
     * 3.不稳定的排序
     * </p>
     */
    @Override
    protected void sort() {
        //找出最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }//O(n)

        //开辟内存空间，存储每个整除出现的次数
        int[] counts = new int[max + 1];
        //统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }//O(n)
        //根据出现次数 对整数进行排序
        for (int i = 0, j = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                array[j++] = i;
                counts[i]--;
            }
        }//O(n)
        //O(n)
    }
}
