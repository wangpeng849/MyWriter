package com.wangp.myaop.leetcode;

/**
 * <pre>
 * classname Code
 * description  日志易笔试题
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/4 16:22
 **/
public class Code {


    public static void main(String[] args) {
        String source = "1112345";
        String str = "45";
        System.out.println(indexOf(source, str));
        System.out.println(source.indexOf(str));
    }

    private static int indexOf(String source, String str) {
        if (source == null || str == null || source.length() == 0 || str.length() == 0) {
            return -1;
        }
        char first = str.charAt(0);
        int max = source.length() - str.length();
        for (int i = 0; i <= max; i++) {
            if (source.charAt(i) != first) {
                continue;
            }
            int j = i + 1;
            int end = str.length() + j - 1;
            for (int k = 1; j < end && source.charAt(j) == str.charAt(k); j++, k++) {

            }
            if (j == end) {
                return i;
            }
        }
        return -1;
    }
}
