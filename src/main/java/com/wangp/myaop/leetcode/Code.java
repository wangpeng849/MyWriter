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
        String source = "     c";
        String str = " c";
        System.out.println(indexOf(source, str));
        System.out.println(source.indexOf(str));
    }

    private static int indexOf(String source, String str) {
        if (source == null || str == null || source.length() == 0 || str.length() == 0) {
            return -1;
        }
        int index = 0;
        int start = -1;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == str.charAt(index)) {
                if (start == -1) {
                    start = i;
                }
                index++;
                if (index == str.length()) {
                    return start;
                }
            } else {
                index = 0;
                start = -1;
            }
        }
        return -1;
    }
}
