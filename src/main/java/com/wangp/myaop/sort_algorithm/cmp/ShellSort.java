package com.wangp.myaop.sort_algorithm.cmp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/5/22
 * @Version 1.0
 */
public class ShellSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {
        List<Integer> stepSequence = sedgewickStepSequence();//步长序列 {8,4,2,1}
//        System.out.println(stepSequence);
        for (Integer step : stepSequence) {
            sort(step);
        }
    }

    /**
     * 分成stop列进行排序
     *
     * @param step
     */
    private void sort(int step) {
        //col ： 第几列
        for (int col = 0; col < step; col++) {
            //第col列排序
            //插入排序代码
            //对[0,array.length)数据排序
            //而希尔排序是step
            for (int begin = col + step; begin < array.length; begin += step) {
                int cur = begin;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
                }
            }
        }
    }

    private List<Integer> shellStepSequence() {
        //希尔的序列为： n/2^k
        List<Integer> stepSequence = new ArrayList<>();
        int step = array.length;
        while ((step >>= 1) > 0) {
            stepSequence.add(step);
        }
        return stepSequence;
    }


    /**
     * 目前已知最好的步长序列
     * 9 * （2^k - 2^(k/2))  + 1  , k even, (偶数)
     * 8 * 2^k - 6 * 2^((k+1)/2) + 1 , k odd. (奇数)
     * 0 -> 1
     * 1 -> 5
     * 2 -> 19
     * 3 -> 41
     * 4 -> 109
     * {1,5,19,41,109....}
     */
    private List<Integer> sedgewickStepSequence() {
        List<Integer> stepSequence = new ArrayList<>();
        int k = 0, step = 0;
        while (true) {
            if (k % 2 == 0) {
                int pow = (int) Math.pow(2, k >> 1);
                step = 9 * (pow * pow - pow) + 1;
            } else {
                int pow = (int) Math.pow(2, k);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 8 * pow - 6 * pow2 + 1;
            }
            if(step > array.length){
                break;
            }
            stepSequence.add(0,step);
            k++;
        }
        return stepSequence;
    }
}
