package com.wangp.myaop.leetcode.middle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <pre>
 * classname Partion
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/12/14 14:09
 **/
public class Partion {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        dfs(ans, path, 0, s.length(), s);
        return ans;
    }

    private void dfs(List<List<String>> ans, Deque<String> path, int index, int len, String s) {
        if (index == len) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            if (!isThisStr(s, index, i)) {
                continue;
            }
            path.addLast(s.substring(index, i + 1));
            dfs(ans, path, i + 1, len, s);
            path.removeLast();
        }
    }

    private boolean isThisStr(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        new Partion().partition("aab");
    }
}
