package com.wangp.myaop.leetcode.simple;

/**
 * <pre>
 * classname longestCommonPrefix
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/2/7 16:04
 **/
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        // 横向
//        for (int i = 1; i < strs.length; i++) {
//            prefix =  longestCommonPrefixByRow(prefix,strs[i]);
//        }
        // 纵向
        int count = strs.length;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            for (int j = 1; j < count; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }

    private String longestCommonPrefixByRow(String prefix, String str) {
        int min = Math.min(prefix.length(), str.length());
        for (int i = 0; i < min; i++) {
            if (prefix.charAt(i) != str.charAt(i)) {
                return prefix.substring(0, i);
            }
        }
        return prefix.substring(0, min);
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
