package com.wangp.myaop.leetcode;

import lombok.Data;

import java.io.File;
import java.util.*;

/**
 * @Author wangp
 * @Date 2020/4/21
 * @Version 1.0
 */
public class Solution {

    /**
     * 优美子数组
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int ans = 0;
        int[] odd = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                odd[++count] = i;
            }
        }
        odd[0] = -1;
        odd[++count] = nums.length;
        for (int i = 1; i + k <= count; i++) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return ans;
    }

    public int numberOfSubarrays2(int[] nums, int k) {
        int preEven = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if ((i & 1) == 0) {
                preEven++;
            } else {
                list.add(preEven + 1);
                preEven = 0;
            }
        }
        list.add(preEven + 1);
        // list.forEach(o-> System.out.println(o));
        int count = 0;
        for (int i = 0; i < list.size() - k; i++) {
            count += (list.get(i) * list.get(i + k));
        }
        return count;
    }

    /**
     * Definition for a binary tree node.
     */
    @Data
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 二叉树的右视图
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightSideViewMap = new HashMap();
        Stack<TreeNode> nodeStack = new Stack();
        Stack<Integer> depthStack = new Stack();
        int max_depth = -1;

        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Integer depth = depthStack.pop();
            max_depth = Math.max(max_depth, depth);
            if (node != null) {
                if (!rightSideViewMap.containsKey(depth)) {
                    rightSideViewMap.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }


        List<Integer> res = new ArrayList();
        for (int depth = 0; depth <= max_depth; depth++) {
            res.add(rightSideViewMap.get(depth));
        }
        return res;
    }


    /**
     * 硬币
     *
     * @param n
     */
    public int waysToChange(int n) {
        final int MOD = 1000000007;
        int ans = 0;
        for (int i = 0; i * 25 <= n; i++) {
            int rest = n - i * 25;
            int a = rest / 10;
            int b = rest % 10 / 5;
            ans = (int) ((ans + (long) (a + 1) * (long) (a + b + 1) % MOD) % MOD);
        }
        return ans;
    }


    /**
     * 删列造序
     *
     * @param A
     * @return
     */
    public int minDeletionSize(String[] A) {
        if(A.length < 2){
            return 0;
        }
        for (int i = 0; i < A.length; i++) {
            String s = A[i];
        }
        return 0;
    }


    /**
     * 数组中的逆序对
     * TODO 归并排序
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.waysToChange(61);
        System.out.println(i);
        int x,y,z;
        x = y = z= 1;
        System.out.println(x+"-"+y+"-"+z);
    }
}
