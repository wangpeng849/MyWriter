package com.wangp.myaop.sort_algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author wangp
 * @Date 2020/5/20
 * @Version 1.0
 */
public class SelectionSort<E  extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 0; begin <= end; begin++) {
                // = 是为了排序算法的稳定性
                if (cmp(maxIndex, begin) <= 0) {
                    maxIndex = begin;
                }
            }
            swap(maxIndex, end);
        }
    }
}
