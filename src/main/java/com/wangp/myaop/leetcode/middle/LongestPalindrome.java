package com.wangp.myaop.leetcode.middle;

/**
 * <pre>
 * classname LongestPalindrome
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/3 15:57
 **/
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                System.out.println(s.substring(i, i + l + 1));
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new LongestPalindrome().longestPalindrome("asdasddsadsa");
    }
}
