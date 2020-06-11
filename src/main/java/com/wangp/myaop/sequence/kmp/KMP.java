package com.wangp.myaop.sequence.kmp;

/**
 * @Author wangp
 * @Date 2020/6/11
 * @Version 1.0
 */
public class KMP {

    public static int indexOf(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int tLen = textChars.length;
        int pLen = patternChars.length;
        if (tLen == 0 || pLen == 0 || pLen > tLen) return -1;

        //next表
        int[] next = next2(pattern);

        int pi = 0, ti = 0;
        while (pi < pLen && ti < tLen) {
            if (pi < 0 || textChars[ti] == patternChars[pi]) {
                ti++;
                pi++;
            } else {
                //失配时
                pi = next[pi];
            }
        }
        return pi == pLen ? (ti - pi) : -1;
    }

    private static int[] next(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0;
        // n == next[i]
        int n = -1;
        int iMax = pattern.length() - 1;
        while (i < iMax) {
            if (n < 0 || pattern.charAt(i) == pattern.charAt(n)) {
                next[++i] = ++n;
            } else {
                n = next[n];
            }
        }

        return next;
    }

    private static int[] next2(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0;
        // n == next[i]
        int n = -1;
        int iMax = pattern.length() - 1;
        while (i < iMax) {
            if (n < 0 || pattern.charAt(i) == pattern.charAt(n)) {
                ++i;
                ++n;
                if(pattern.charAt(i) == pattern.charAt(n)){
                    next[i] = next[n];
                }else{
                    next[i] = n;
                }
            } else {
                n = next[n];
            }
        }

        return next;
    }
}
