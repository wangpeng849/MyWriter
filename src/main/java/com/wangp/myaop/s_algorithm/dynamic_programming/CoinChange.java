package com.wangp.myaop.s_algorithm.dynamic_programming;

import io.lettuce.core.ScriptOutputType;

import java.util.Arrays;

/**
 * @Author wangp
 * @Date 2020/6/5
 * @Version 1.0
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().coins3(41));
        System.out.println(new CoinChange().coins5(new int[]{5, 20, 25}, 19));
    }

    /**
     * 暴力递归
     *
     * @param n
     * @return
     */
    int coins1(int n) {
        if (n < 1) return Integer.MAX_VALUE;
        if (n == 25 || n == 20 || n == 5 || n == 1) return 1;
        int min1 = Math.min(coins1(n - 25), coins1(n - 20));
        int min2 = Math.min(coins1(n - 5), coins1(n - 1));
        return Math.min(min1, min2) + 1;
    }

    /**
     * 记忆化搜索
     *
     * @param n
     * @return
     */
    int coins2(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        int[] faces = {1, 5, 20, 25};
        for (int face : faces) {
            if (n < face) break;
            dp[face] = 1;
        }
        return coins2(n, dp);
    }

    int coins2(int n, int[] dp) {
        if (n < 1) return Integer.MAX_VALUE;
        if (dp[n] == 0) {
            int min1 = Math.min(coins2(n - 25, dp), coins2(n - 20, dp));
            int min2 = Math.min(coins2(n - 5, dp), coins2(n - 1, dp));
            dp[n] = Math.min(min1, min2) + 1;
        }
        return dp[n];
    }

    /**
     * 递推
     *
     * @param n
     * @return
     */
    int coins3(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        //凑够i分时最后选择的那枚硬币的面值
        int[] faces = new int[dp.length];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i >= 1 && dp[i - 1] < min) {
                min = Math.min(dp[i - 1], min);
                faces[i] = 1;
            }
            if (i >= 5 && dp[i - 5] < min) {
                min = Math.min(dp[i - 5], min);
                faces[i] = 5;
            }
            if (i >= 20 && dp[i - 20] < min) {
                min = Math.min(dp[i - 20], min);
                faces[i] = 20;
            }
            if (i >= 25 && dp[i - 25] < min) {
                min = Math.min(dp[i - 25], min);
                faces[i] = 25;
            }
            dp[i] = min + 1;
            print(faces, i);
        }
        return dp[n];
    }

    static void print(int[] faces, int n) {
        System.out.print("[" + n + "]= ");
        while (n > 0) {
            System.out.print(faces[n] + ",");
            n -= faces[n];
        }
        System.out.println();
    }

    int coins5(int[] faces, int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        //凑够i分时最后选择的那枚硬币的面值
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int face : faces) {
                if (i < face || dp[i - face] < 0) continue;
                min = Math.min(dp[i - face], min);
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[n];
    }

}
