package com.wangp.myaop.leetcode.simple;

/**
 * <pre>
 * classname ReverseLeftWords
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/5 17:51
 **/
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0, n);
        String s2 = s.substring(n);
        return s2 + s1;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseLeftWords().reverseLeftWords("abcdefg", 2));
    }
}
