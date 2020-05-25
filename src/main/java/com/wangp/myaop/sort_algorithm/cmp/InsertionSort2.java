package com.wangp.myaop.sort_algorithm.cmp;

/**
 * @Author wangp
 * @Date 2020/5/21
 * @Version 1.0
 */
public class InsertionSort2<E extends Comparable<E>> extends Sort<E> {
    //将交换转为挪动
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            E v = array[cur];
            while (cur > 0  && cmp(v, array[cur - 1]) < 0) {
                //全部挪动到后面
                array[cur] = array[cur-1];
                cur--;
            }
            array[cur] = v;
        }
    }
}
