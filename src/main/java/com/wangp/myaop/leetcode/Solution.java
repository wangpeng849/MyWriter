package com.wangp.myaop.leetcode;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.thymeleaf.model.IStandaloneElementTag;

import javax.management.Query;
import java.io.File;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

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
        if (A.length < 2) {
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
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> output = new ArrayList();
        for (int num : nums) {
            output.add(num);
        }

        List<List<Integer>> res = new LinkedList<>();
        backtrack(nums.length, res, output, 0);
        return res;
    }

    private void backtrack(int n, List<List<Integer>> res, List<Integer> output, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrack(n, res, output, first + 1);
            Collections.swap(output, first, i);
        }
    }


    /**
     * 搜索旋转排序数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int size = nums.length;
        if (size <= 0) {
            return -1;
        }
        if (size == 1) {
            return nums[size] == target ? 0 : -1;
        }
        int l = 0;
        int r = size - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[size - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


    /**
     * 数组中数字出现的次数
     *
     * @param
     */
    public int[] singleNumbers(int[] nums) {
        int[] ans = new int[2];
        int ret = 0;
        for (int n : nums)
            ret ^= n;
        int div = 1;
        while ((div & ret) == 0)
            div <<= 1;
        int a = 0, b = 0;
        for (int n : nums)
            if ((div & n) != 0)
                a ^= n;
            else
                b ^= n;
        ans[0] = a;
        ans[1] = b;
        return ans;
    }

    /**
     * 独一无二的出现次数
     *
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int value = map.get(arr[i]);
                map.put(arr[i], ++value);
            } else {
                map.put(arr[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Set set = new HashSet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            set.add(entry.getValue());
        }
        return map.size() == set.size();
    }

    /**
     * 数字跳跃
     *
     * @param nums
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
            }
            if (rightmost >= n - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 跳跃游戏2
     *
     * @param nums O(n^2)
     * @return
     */
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    /**
     * 跳跃游戏2
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int len = nums.length;
        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    /**
     * 验证是否为二叉搜索树
     * 方法一: 递归
     *
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!helper(node.right, val, upper)) return false;
        if (!helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    /**
     * 验证是否为二叉搜索树
     * 方法二：中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * 最小栈
     *
     * @param
     */
    static class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> min_stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack();
            min_stack = new Stack();
        }

        public void push(int x) {
            stack.push(x);
            if (!min_stack.isEmpty()) {
                int top = min_stack.peek();
                //小于的时候才入栈
                if (x <= top) {
                    min_stack.push(x);
                }
            }else{
                min_stack.push(x);
            }
        }

        public void pop() {
            int pop = stack.pop();
            int top = min_stack.peek();
            if(top == pop) {
                min_stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }

    /**
     * 最小栈 2
     * 不用辅助栈
     */
    static class MinStack2{

        private Stack<Integer> stack;
        private Integer min=Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack2() {
            stack = new Stack();
        }

        public void push(int x) {
           if(x<min){
               stack.push(min);
               min = x;
           }
           stack.push(x);
        }

        public void pop() {
            int pop = stack.pop();
            if(pop==min){
                  min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    /**
     * 二叉树层次遍历
     * @param
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        inorderTraverse(res,root,0);
        return res;
    }

    private void inorderTraverse(List<List<Integer>> res,TreeNode root, int level) {
        if(root!=null){
            if(res.size() == level){
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            inorderTraverse(res,root.left,level+1);
            inorderTraverse(res,root.right,level+1);
        }
    }

    /**
     *  整数翻转
     * @param error
     */
    public int reverseInt(int num){
        if(num==0 || num<Integer.MIN_VALUE || num > Integer.MAX_VALUE) {
            return 0;
        }
        String numStr = num+"";
        String res = StringUtils.reverse(numStr);
        if(res.endsWith("-")){
            res = ("-"+res).substring(0,res.length());
        }
        int result = Integer.valueOf(res) > Integer.MAX_VALUE ? 0 :
                Integer.valueOf(res) < Integer.MIN_VALUE ? 0:Integer.valueOf(res);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        树模拟数据
//        TreeNode root = new TreeNode(0);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        node3.setLeft(node2);
//        node3.setRight(node4);
//        node2.setLeft(root);
//        root.setRight(node1);
//        node4.setRight(node6);
//        node6.setLeft(node5);
//        List<List<Integer>> lists = solution.levelOrder(node3);
//        System.out.println(lists);
    }


    public void preOrderTree(TreeNode root) {
        if (root != null) {
            System.out.println(root.val + " ");
            preOrderTree(root.left);
            preOrderTree(root.right);
        }
    }

    public void midOrderTree(TreeNode root) {
        if (root != null) {
            midOrderTree(root.left);
            System.out.println(root.val + " ");
            midOrderTree(root.right);
        }
    }

    public void postOrderTree(TreeNode root) {
        if (root != null) {
            postOrderTree(root.left);
            postOrderTree(root.right);
            System.out.println(root.val + " ");
        }
    }
}
