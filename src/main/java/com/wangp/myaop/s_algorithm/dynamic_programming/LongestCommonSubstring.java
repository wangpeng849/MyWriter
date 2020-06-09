package com.wangp.myaop.s_algorithm.dynamic_programming;

/**
 * @Author wangp
 * @Date 2020/6/8
 * @Version 1.0
 */
//3-最长公共子串
public class LongestCommonSubstring {

    public static void main(String[] args) {
        System.out.println(lcs_arr("ABCBA", " "));
    }

    /**
     * 一位数组优化
     *
     * @param str1
     * @param str2
     * @return
     */
    static int lcs_arr(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;
        char[] chars1 = str1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = str2.toCharArray();
        if (chars2.length == 0) return 0;

        /**
         * 挑两个数组短的
         */
        char[] rowChars = chars1, colsChars = chars2;
        if (chars1.length < chars2.length) {
            rowChars = chars2;
            colsChars = chars1;
        }
        int[] dp = new int[colsChars.length + 1];
        int max = dp[0];
        for (int row = 1; row <= rowChars.length; row++) {
            int cur = 0;
            for (int col = 1; col <= colsChars.length; col++) {
                int leftTop = cur;
                cur = dp[col];
                if (chars1[row - 1] != chars2[col - 1]) {
                    dp[col] = 0;
                } else {
                    dp[col] = leftTop + 1;
                    max = Math.max(dp[col], max);
                }
            }
        }
        return max;
    }


    static int lcs(String str1, String str2) {
        /*
        i ∈ [1,str1.length -1]
        j ∈ [1,str2.length -1]
        dp(i,j) 是以 str1[i-1]、str2[j-1]结尾的最长公共子串长度
            dp(i,0)、dp(0,j)初始值均为0
            1. str1[i-1]=str2[j-1] --> dp(i,j) = dp(i-1,j-1) + 1
            2. str1[i-1]!=str2[j-1] --> dp(i,j) = 0
         */
        if (str1 == null || str2 == null) return 0;
        char[] chars1 = str1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = str2.toCharArray();
        if (chars2.length == 0) return 0;

        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        int max = dp[0][0];
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] != chars2[j - 1]) continue;
                dp[i][j] = dp[i - 1][j - 1] + 1;
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
