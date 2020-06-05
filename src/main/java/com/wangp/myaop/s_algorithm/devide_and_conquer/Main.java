package com.wangp.myaop.s_algorithm.devide_and_conquer;

/**
 * @Author wangp
 * @Date 2020/6/4
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(devideAndConquer(nums));
    }

    static int devideAndConquer(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return devideAndConquer(nums, 0, nums.length);
    }

    /**
     * 求[begin,end）中最大连续子序列的和
     *
     * @param nums
     * @param begin
     * @param end
     * @return
     */
    private static int devideAndConquer(int[] nums, int begin, int end) {
        if (end - begin < 2) {
            return nums[begin];
        }
        int mid = (begin + end) >> 1;
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }

        return Math.max(
                rightMax + leftMax,
                Math.max(
                        devideAndConquer(nums, begin, mid),
                        devideAndConquer(nums, mid, end))
        );
    }


    //O(n^2)
    static int maxSubarray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            int sum = 0;
            for (int end = begin; end < nums.length; end++) {
                //[begin,end]
                sum += nums[end];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    //O(n^3)
    static int maxSubarray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            for (int end = begin; end < nums.length; end++) {
                //[begin,end]
                int sum = 0;
                for (int i = begin; i <= end; i++) {
                    sum += nums[i];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
