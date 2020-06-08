package com.wangp.myaop.s_algorithm.dynamic_programming;

/**
 * @Author wangp
 * @Date 2020/6/8
 * @Version 1.0
 */
//最长公共子序列 LCS
public class LongestCommonSubsequence {
    //[1,3,5,9,10] 和 [1,4,9,10] 的最长公共子序列是 [1,9,10] 长度为3
    // ABCBDAB 和 BDCABA --> BDAB,BCAB,BCBA
    public static void main(String[] args) {
//        int len = lcs_dg(new int[]{1, 3, 5, 9, 10},
//                new int[]{1, 4, 9, 10});
//        int len = lcs_arr(new int[]{1, 4, 5, 9, 10},
//                new int[]{1, 4, 9, 10});
        int len = lcs_array(new int[]{1, 4, 5, 9, 10},
                new int[]{1, 4, 9, 10});
        System.out.println(len);
    }

    /*
        非递归实现（一维数组）
     */
    static int lcs_array(int[] nums1, int[] nums2) {
        // i ∈ [0,nums1.length)
        // j ∈ [0,nums2.length)
        //假设 dp(i,j)是【nums1 前i个元素】与【nums2前j个元素】的最长公共子序列
        //dp(i,0) 与 dp(0,j)初始值为 0
        int[] dp = new int[nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            int cur = 0;
            for (int j = 1; j <= nums2.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[nums2.length];
    }


    /*
        非递归实现（滚动数组）
     */
    static int lcs_arr(int[] nums1, int[] nums2) {
        // i ∈ [0,nums1.length)
        // j ∈ [0,nums2.length)
        //假设 dp(i,j)是【nums1 前i个元素】与【nums2前j个元素】的最长公共子序列
        //dp(i,0) 与 dp(0,j)初始值为 0
        int[][] dp = new int[2][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            int row = i & 1;
            int prevRow = (i - 1) & 1;
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[row][j] = dp[prevRow][j - 1] + 1;
                } else {
                    dp[row][j] = Math.max(dp[prevRow][j], dp[row][j - 1]);
                }
            }
        }
        return dp[nums1.length & 1][nums2.length];
    }


    /*
        非递归实现（动态规划）
     */
    static int lcs(int[] nums1, int[] nums2) {
        // i ∈ [0,nums1.length)
        // j ∈ [0,nums2.length)
        //假设 dp(i,j)是【nums1 前i个元素】与【nums2前j个元素】的最长公共子序列
        //dp(i,0) 与 dp(0,j)初始值为 0
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }


    /*
        递归实现
     */
    static int lcs_dg(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        return lcs_dg(nums1, nums1.length, nums2, nums2.length);
    }

    static int lcs_dg(int[] nums1, int i, int[] nums2, int j) {
        if (i == 0 || j == 0) return 0;
        if (nums1[i - 1] == nums2[j - 1]) {
            return lcs_dg(nums1, i - 1, nums2, j - 1) + 1;
        }
        return Math.max(lcs_dg(nums1, i - 1, nums2, j), lcs_dg(nums1, i, nums2, j - 1));
    }
}
