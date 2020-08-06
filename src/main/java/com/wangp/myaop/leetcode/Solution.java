package com.wangp.myaop.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

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
     * 数组中的逆序对 TODO 归并排序
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
            if (nums[mid] == target) {
                return mid;
            }
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
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
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
     * 验证是否为二叉搜索树 方法一: 递归
     *
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    /**
     * 验证是否为二叉搜索树 方法二：中序遍历
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
            if (root.val <= inorder) {
                return false;
            }
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
            } else {
                min_stack.push(x);
            }
        }

        public void pop() {
            int pop = stack.pop();
            int top = min_stack.peek();
            if (top == pop) {
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
     * 最小栈 2 不用辅助栈
     */
    static class MinStack2 {

        private Stack<Integer> stack;
        private Integer min = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack2() {
            stack = new Stack();
        }

        public void push(int x) {
            if (x < min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            int pop = stack.pop();
            if (pop == min) {
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
     *
     * @param
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        inorderTraverse(res, root, 0);
        return res;
    }

    private void inorderTraverse(List<List<Integer>> res, TreeNode root, int level) {
        if (root != null) {
            if (res.size() == level) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            inorderTraverse(res, root.left, level + 1);
            inorderTraverse(res, root.right, level + 1);
        }
    }

    /**
     * 整数翻转
     *
     * @param error
     */
    public int reverseInt(int num) {
        if (num == 0 || num < Integer.MIN_VALUE || num > Integer.MAX_VALUE) {
            return 0;
        }
        String numStr = num + "";
        String res = StringUtils.reverse(numStr);
        if (res.endsWith("-")) {
            res = ("-" + res).substring(0, res.length());
        }
        int result = Integer.valueOf(res) > Integer.MAX_VALUE ? 0 :
                Integer.valueOf(res) < Integer.MIN_VALUE ? 0 : Integer.valueOf(res);
        return result;
    }

    /**
     * 乘积最大子数组
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int tmp_max = 1;
        int tmp_min = 1;
        for (int i = 0; i < nums.length; i++) {
            tmp_max = tmp_max * nums[i];
            tmp_min = tmp_min * nums[i];
            if (nums[i] < 0) {
                tmp_max = tmp_min ^ tmp_max;
                tmp_min = tmp_min ^ tmp_max;
                tmp_max = tmp_min ^ tmp_max;
            }
            tmp_max = Math.max(tmp_max, nums[i]);
            tmp_min = Math.min(tmp_min, nums[i]);
            max = Math.max(tmp_max, max);
        }
        return max;
    }


    public int findTheLongestSubstring(String s) {
        int n = s.length();
        //5个元音字母，就是00000-11111，2^5种情况，或者叫状态
        int[] pos = new int[1 << 5];
        //用-1填充是怕00000这种情况，避免混淆
        Arrays.fill(pos, -1);
        int ans = 0;
        int status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            /*-------------开始----------------*/
            //在这里主要是用当前字符去更新上一个子串的状态，因为当前这个字符可能是元音字符或者不是
            //用异或的原因就是，我们只关心奇偶性，异或相同为0，不同为1，那么只要将上一个状态对应位与
            //1 << （0-4）一下就可以了。也就是第一次来是奇数，那么第二次就是偶数，第三次是奇数...
            if (ch == 'a') {
                status ^= (1 << 0); // 1
            } else if (ch == 'e') {
                status ^= (1 << 1); // 2
            } else if (ch == 'i') {
                status ^= (1 << 2); // 4
            } else if (ch == 'o') {
                status ^= (1 << 3); // 8
            } else if (ch == 'u') {
                status ^= (1 << 4); // 16
            }
            /*--------------结束---------------*/
            //得到一个新的状态值，如果这个状态值作索引对应位置的值大于0，
            //那么就说明第一次出现该值的位置到当前位置所对应的字符串就是当前
            //符合要求的子串，这是因为如果在i的位置和j的位置对应的状态值相等，
            //那么这两个子串的奇偶性肯定相等,既然奇偶性相同了，那么中间范围对应的子串就是我们要求的
            //同时我们要和之前符合要求的子串比较一下长度，因为我们要取最长的。
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                //pos只存放每一个状态值第一个出现的位置。
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    /**
     * 打家劫舍
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    /**
     * 使用最小花费爬楼梯
     *
     * @param cost
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    /**
     * 二进制相加
     *
     * @param a
     * @param b
     * @return
     */
//    public String addBinary(String a, String b) {
//        int anum = 0;
//        int bnum = 0;
//        int count = 0;
//        for (int i =  a.length() -1 ; i >= 0; i--) {
//            if(a.charAt(i) == '1') {
//                anum += (int) Math.pow(2, count);
//            }
//            count++;
//        }
//        count = 0;
//        for (int i =  b.length() -1 ; i >= 0; i--) {
//            if(b.charAt(i) == '1') {
//                bnum += (int) Math.pow(2,count);
//            }
//            count++;
//        }
//        return Integer.toBinaryString(anum+bnum);
//    }
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    class CQueue {

        Stack<Integer> inStack;
        Stack<Integer> outStack;

        public CQueue() {
            inStack = new Stack();
            outStack = new Stack();
        }

        public void appendTail(int value) {
            inStack.push(value);
        }

        public int deleteHead() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            if (outStack.isEmpty()) {
                return -1;
            } else {
                int deleteItem = outStack.pop();
                return deleteItem;
            }
        }
    }

    /**
     * 不同路劲 I
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsImprove(int m, int n) {
        int[] curLine = new int[n];
        int[] preLine = new int[n];

        Arrays.fill(curLine, 1);
        Arrays.fill(preLine, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                curLine[j] = preLine[j] + curLine[j - 1];
            }
            preLine = curLine.clone();
        }
        return curLine[n - 1];
    }

    public int uniquePathsImproveImprove(int m, int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[j] += arr[j - 1];
            }
        }
        return arr[n - 1];
    }

    /**
     * 不同路劲 II  有障碍物
     *
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] arr = new int[m];

        arr[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    arr[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    arr[j] += arr[j - 1];
                }
            }
        }
        return arr[m - 1];
    }

    /**
     * 路径总和
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 跳水板
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k < 1) {
            return new int[]{};
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] lens = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            lens[i] = shorter * (k - i) + longer * i;
        }
        return lens;
    }

    /**
     * 恢复空格
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();
        List<String> dicList = Arrays.asList(dictionary);
        int[] dp = new int[n + 1];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (dicList.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[n];

        //动态规划
//            int n = sentence.length();
//            int m = dictionary.length;
//            int[] dp = new int[n + 1];
//            for (int i = 1; i <= n; i++) {
//                dp[i] = dp[i-1];
//                for (int j = 0; j < m ; j++) {
//                    if (i < dictionary[j].length()) continue;
//                    if (sentence.substring(i - dictionary[j].length(), i).equals(dictionary[j])) {
//                        dp[i] = Math.max(dp[i - dictionary[j].length()] + dictionary[j].length(), dp[i]);
//                    }
//                }
//            }
//            return n - dp[n];
    }

    /**
     * 数组交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                res[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    /**
     * 三角形最小边
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0) == null) {
            return 0;
        }
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            dp[i] = Integer.MAX_VALUE;
            for (Integer sub : triangle.get(i)) {
                dp[i] = Math.min(dp[i], dp[i - 1] + sub);
            }
        }
        return dp[triangle.size() - 1];
    }

    /**
     * 股票最佳时机
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                maxProfit = Math.max(price - min, maxProfit);
            }
        }
        return maxProfit;
    }

    /**
     * 三步问题
     *
     * @param n
     * @return
     */
    public int waysToStep(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        if (n < 4) {
            return (int) dp[n];
        }
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007;
        }
        return (int) dp[n];
    }

    /**
     * 按摩师
     *
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int massageImprove(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = b;
            b = Math.max(a + nums[i], b);
            a = c;
        }
        return b;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 判断子序列
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : s.toCharArray()) {
            while (i < t.length() && t.charAt(i) != c) {
                i++;
            }
            i++;
        }
        return i <= t.length();
    }

    /**
     * @param words
     * @return 已超时
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> palindromePair = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                System.out.println("i=" + i + ",j=" + j);
                String one = words[i];
                String two = words[j];
                if (canPair(one, two)) {
                    palindromePair.add(Arrays.asList(i, j));
                }
            }
        }
        return palindromePair;
    }

    private boolean canPair(String one, String two) {
        String str = one + two;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        树模拟数据
//        TreeNode root = new TreeNode(5);
//        TreeNode node1 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(8);
//        TreeNode node3 = new TreeNode(11);
//        TreeNode node4 = new TreeNode(13);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(7);
//        TreeNode node7 = new TreeNode(2);
//        TreeNode node8 = new TreeNode(1);
//        root.setLeft(node1);
//        root.setRight(node2);
//        node1.setLeft(node3);
//        node2.setLeft(node4);
//        node2.setRight(node5);
//        node3.setLeft(node6);
//        node3.setRight(node7);
//        node4.setRight(node8);
        System.out.println(solution.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
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
