package com.wangp.myaop.leetcode.simple;

import java.util.Arrays;

/**
 * <pre>
 * classname RunningSum
 * description
 *
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * 请返回 nums 的动态和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/5 17:19
 **/
public class RunningSum {

    public int[] runningSum(int[] nums) {
//        int[] front = new int[nums.length];
//        int[] res = new int[nums.length];
//        Arrays.fill(front, 0);
//        res[0] = front[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            res[i] = front[i] = front[i - 1] + nums[i];
//        }
//        return res;

        // --------------- GOOD --------------
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RunningSum().runningSum(new int[]{1, 2, 3, 4, 5})));
    }
}
