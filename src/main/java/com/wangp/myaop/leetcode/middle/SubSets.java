package com.wangp.myaop.leetcode.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 * classname SubSets
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/12/9 15:16
 **/
public class SubSets {

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            t.clear();
            // 001 110
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    t.add(nums[j]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SubSets().subsets(new int[]{1, 2, 3}));
        Set set1 = new HashSet<>();
        Set set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(1);
        set2.add(2);
        set2.add(3);
        System.out.println(set1 == set2);
    }
}
