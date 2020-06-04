package com.wangp.myaop.s_algorithm.recursion;

import com.wangp.myaop.union_find.util.Times;

/**
 * @Author wangp
 * @Date 2020/6/3
 * @Version 1.0
 * <p>
 * 递归的基本思想
 * <p>
 * 拆解问题
 * 1.把规模大的问题变成规模较小的同类型问题
 * 2.把规模较小的问题变成更小的问题
 * 3.规模小到一定程度可以直接得出解
 * <p>
 * 求解
 * 1.由最小规模问题得出较大问题的解
 * 2.由较大问题的解不断得出规模更大问题的解
 * 3.最后得出原来问题的解
 * <p>
 * 很多链表和二叉树都可以用递归解决
 * <p>
 * <p>
 * 递归的使用套路
 * 1.明确函数的功能
 * 2.明确原问题与子问题的关系
 * 3.明确递归基
 * <p>
 * 递归调用的空间复杂度 = 递归深度 * 每次调用所需的辅助空间
 */
public class Recursion {

    /**
     * 规模为n 的累加
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public static int sum(int n) {
        if (n <= 1) return n;
        return n + sum(n - 1);
    }


    /**
     * 斐波那契数列
     * <p>
     * 时间复杂度 O(2^n)
     * 空间复杂度 O(n)
     * <p>
     * 出现了特别多的重复计算
     *
     * @param n
     */
    static int fib0(int n) {
        if (n <= 2) return 1;
        return fib0(n - 1) + fib0(n - 2);
    }

    /**
     * 用数据优化斐波那契数列
     *
     * @param n
     * @return
     */
    static int fib1(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        return fib1(n, array);
    }

    static int fib1(int n, int[] array) {
        if (array[n] == 0) {
            array[n] = fib1(n - 1, array) + fib1(n - 2, array);
        }
        return array[n];
    }

    /**
     * 删除递归优化
     *
     * @param n
     * @return
     */
    static int fib2(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    /**
     * 滚动数组优化
     *
     * @param n
     * @return
     */
    static int fib3(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[1] = array[0] = 1;
        for (int i = 3; i <= n; i++) {
            array[i % 2] = array[(i - 1) % 2] + array[(i - 2) % 2];
        }
        return array[n % 2];
    }


    /**
     * 滚动数组优化
     * 位运算
     * @param n
     * @return
     */
    static int fib4(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[1] = array[0] = 1;
        for (int i = 3; i <= n; i++) {
            array[i & 1] = array[(i - 1) & 1] + array[(i - 2) & 1];
        }
        return array[n & 1];
    }

    public static void main(String[] args) throws IllegalAccessException {
//        System.out.println(sum(100));
//        Times.test("fib0", () -> {
//            System.out.println(fib0(15));
//        });
        int count = 65;
        Times.test("fib1", () -> {
            System.out.println(fib1(65));
        });
        Times.test("fib2", () -> {
            System.out.println(fib2(65));
        });
        Times.test("fib3", () -> {
            System.out.println(fib3(65));
        });
        Times.test("fib4", () -> {
            System.out.println(fib4(65));
        });
    }


    /**
     * 递归转非递归
     */
}
