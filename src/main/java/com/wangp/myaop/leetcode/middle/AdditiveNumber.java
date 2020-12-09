package com.wangp.myaop.leetcode.middle;

/**
 * <pre>
 * classname AdditiveNumber
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/12/9 17:03
 **/
public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        return dfs(num, num.length(), 0, 0, 0, 0);
    }

    public boolean dfs(String num, int len, int idx, int sum, int pre, int k) {
        if (idx == len) {
            return k > 2;
        }
        for (int i = idx; i < len; i++) {
            int cur = fetchCurNum(num, idx, i);
            if (cur < 0) {
                continue;
            }
            if (k >= 2 && cur != sum) {
                continue;
            }
            if (dfs(num, len, i + 1, pre + cur, cur, k + 1)) {
                return true;
            }
        }
        return false;
    }

    private int fetchCurNum(String num, int l, int r) {
        if (l < r && num.charAt(l) == '0') {
            return -1;
        }
        int res = 0;
        while (l <= r) {
            res += res * 10 + num.charAt(l++) - '0';
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new AdditiveNumber().isAdditiveNumber("199100199"));
    }

}
