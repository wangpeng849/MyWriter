package com.wangp.myaop.sequence.brute_force;

/**
 * @Author wangp
 * @Date 2020/6/11
 * @Version 1.0
 */

/**
 * 蛮力匹配
 * <p>
 * 固定ti位置  ： ti 为每一轮比较重 文本串首个比较字符的位置
 *
 * O(n*m)
 */
public class BruteForce03 {

    public static int indexOf(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int tLen = textChars.length;
        int pLen = patternChars.length;
        if (tLen == 0 || pLen == 0 || pLen > tLen) return -1;

        int tiMax = tLen - pLen;
        for (int ti = 0; ti <= tiMax; ti++) {
            int pi = 0;
            for (; pi < pLen; pi++) {
                if (textChars[ti + pi] != patternChars[pi]) break;
            }
            if (pi == pLen) return ti;
        }
        return -1;
    }
}
