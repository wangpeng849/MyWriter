package com.wangp.myaop.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * classname Combine
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/12/2 17:35
 **/
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), n, k, 1);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> combine, int n, int k, int index) {
        if (combine.size() == k) {
            List<Integer> list = new ArrayList<>(combine);
            ans.add(list);
        } else {
            for (int i = index; i <= n; i++) {
                combine.add(i);
                dfs(ans, combine, n, k, i + 1);
                combine.remove(Integer.valueOf(i));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }
}
