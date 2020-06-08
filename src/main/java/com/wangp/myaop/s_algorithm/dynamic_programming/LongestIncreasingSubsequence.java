package com.wangp.myaop.s_algorithm.dynamic_programming;

/**
 * @Author wangp
 * @Date 2020/6/8
 * @Version 1.0
 */

//最长上升子序列 LIS
public class LongestIncreasingSubsequence {
    //给定一个无序的整数序列 求出它最长上升子序列的长度 （严格上升）
    //[10,2,2,5,1,7,101,18] 的最长上升子序列是 [2,5,7,101],[2,5,7,18] 长度是4

    //假设nums,[10,2,2,5,1,7,101,18]
    //dp(i)是以nums[i]结尾的最长上升子序列的长度，初始值为1
    //nums[0] 10结尾的最上升子序列是10 dp(0) = 1
    //nums[1] 2结尾的最上升子序列是2 dp(1) = 1
    //nums[2] 2结尾的最上升子序列是2 dp(2) = 1
    //nums[3] 5结尾的最上升子序列是2,5 dp(3) = 2
    //nums[4] 1结尾的最上升子序列是1 dp(4) = 1
    //nums[5] 1结尾的最上升子序列是2,5,7 dp(5) = 3
    //nums[6] 101结尾的最上升子序列是2,5,7,101 dp(6) = 4
    //nums[7] 18结尾的最上升子序列是2,5,7,18 dp(7) = 4

    //状态定义：

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,2,2,5,1,7,101,18}));
    }

    static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
