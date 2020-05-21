package com.wangp.myaop.sort_algorithm;

import org.springframework.util.Assert;

import java.util.Random;

/**
 * @Author wangp
 * @Date 2020/5/20
 * @Version 1.0
 */
public class ArrayUtil {

    static Random random = new Random();

    public static Integer[] getRandomArr(int capacity) {
        Integer[] arr = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            int r = random.nextInt(capacity);
            arr[i] = r;
        }
        return arr;
    }

    public static Integer[] getDescArr(int capacity) {
        Integer[] arr = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = capacity - i;
        }
        return arr;
    }

    public static Integer[] getAscArr(int capacity) {
        Integer[] arr = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static Integer[] copy(Integer[] arr) {
        Integer[] copy = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static boolean isAscOrder(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void test(boolean b) {
        Assert.isTrue(b, "Not!");
    }
}
