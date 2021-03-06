package com.wangp.myaop.sort_algorithm.cmp;

/**
 * @Author wangp
 * @Date 2020/5/20
 * @Version 1.0
 */
public class BubbleSort<E  extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (cmp(j,j+1)>0) {
                    swap(j,j+1);
                }
            }
        }
    }
}
