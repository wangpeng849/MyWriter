package com.wangp.myaop.s_algorithm.recursion;

/**
 * @Author wangp
 * @Date 2020/6/3
 * @Version 1.0
 * <p>
 * 爬楼梯
 */
public class ClimbStairs {

    /**
     * 和斐波那契基本一致
     *
     * @param n
     * @return
     */
    int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 优化
     */
    int climbStairsPre(int n) {
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }
}
