package com.wangp.myaop.sort_algorithm.cmp;

import com.wangp.myaop.sort_algorithm.CountingSort;
import com.wangp.myaop.sort_algorithm.CountingSort2;
import com.wangp.myaop.sort_algorithm.RadixSort;

import java.text.ParseException;
import java.util.Arrays;

/**
 * @Author wangp
 * @Date 2020/5/20
 * @Version 1.0
 */
@SuppressWarnings({"rawtypes","unchecked"})//消除泛型警告
public class Main {

    public static void main(String[] args) throws ParseException {
        Integer [] arr  = Integers.random(50000,1,50000);
        testSorts(arr,
                new SelectionSort(),
                new HeapSort(),
                new BubbleSort3(),
                new InsertionSort3(),
                new MergeSort(),
                new QuickSort(),
                new ShellSort(),
//                new CountingSort2()
                new RadixSort()
        );
    }

    static void testSorts(Integer[] array,Sort...sorts){
        for (Sort sort : sorts) {
            Integer[] copy = ArrayUtil.copy(array);
            sort.sort(copy);
            ArrayUtil.test(ArrayUtil.isAscOrder(copy));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }

    }
}
