package com.wangp.myaop.sort_algorithm.cmp;

/**
 * @Author wangp
 * @Date 2020/5/20
 * @Version 1.0
 */
public class BubbleSort1<E  extends Comparable<E>> extends Sort<E>{

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                }
            }
        }
    }
}
