package com.wangp.myaop.sort_algorithm;

/**
 * @Author wangp
 * @Date 2020/5/25
 * @Version 1.0
 */

import com.wangp.myaop.sort_algorithm.cmp.Sort;

/**
 * 基数排序非常适合用于整数排序（非负整数）
 * 依次对个位数 百位数 千位数...排序
 *
 * 基数排序基于计数排序
 */
public class RadixSort  extends Sort<Integer> {

    @Override
    protected void sort() {
        //找出最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        // array[i] / 1/ %10
        // array[i] / 10/ %10
        // array[i] / 100/ %10
        for (int divider = 1; divider <= max; divider*=10) {
             countingSort(divider);
        }
    }

    private void countingSort(int divider){
        //开辟内存空间，存储次数
        int[] counts = new int[10];
        //统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i]/divider%10]++;
        }
        //累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i]+=counts[i-1];
        }
        //从后遍历元素，将他放到有序数组合适的位置
        int[] newArray = new int[array.length];
        for (int i = array.length -1; i >= 0; i--) {
//            --counts[array[i] - min];
            newArray[--counts[array[i]/divider%10]] = array[i];
        }
        //将有序数组覆盖array
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }
}
