package com.wangp.myaop.sort_algorithm.cmp;

/**
 * @Author wangp
 * @Date 2020/5/20
 * @Version 1.0
 */
public class BubbleSort2<E  extends Comparable<E>> extends Sort<E>{
    //优化1
    //如果数组本身就是有序的 就没必要继续排序
    @Override
    protected void sort() {
        boolean sorted = true;
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                    sorted = false;
                }
            }
            if(sorted) break;
        }
    }
}
