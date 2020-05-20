package com.wangp.myaop.sort_algorithm;

import java.util.Arrays;

/**
 * @Author wangp
 * @Date 2020/5/20
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        int[] arr  = ArrayUtil.getAscArr(10000);
        testSorts(arr,
                new SelectionSort(),
                new HeapSort(),
                new BubbleSort3(),
                new BubbleSort(),
                new BubbleSort1(),
                new BubbleSort2());
    }

    static void testSorts(int[] array,Sort...sorts){
        for (Sort sort : sorts) {
            sort.sort(ArrayUtil.copy(array));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }

    }
}
