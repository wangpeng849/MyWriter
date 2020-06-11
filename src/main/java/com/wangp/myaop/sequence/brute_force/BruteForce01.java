package com.wangp.myaop.sequence.brute_force;

/**
 * @Author wangp
 * @Date 2020/6/11
 * @Version 1.0
 */

/**
 * 蛮力匹配
 */
public class BruteForce01 {

    public static int indexOf(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int tLen = textChars.length;
        int pLen = patternChars.length;
        if (tLen == 0 || pLen == 0 || pLen > tLen) return -1;

        int pi = 0, ti = 0;
        while (pi < pLen && ti < tLen) {
            if (textChars[ti] == patternChars[pi]) {
                ti++;
                pi++;
            } else {
                ti -= pi - 1;
                pi = 0;
            }
        }
        return pi == pLen ? (ti - pi) : -1;
    }
}
