package com.wangp.myaop.leetcode.middle;

/**
 * <pre>
 * classname NextPermutation
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/2/18 11:34
 **/
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] > nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] > nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1, 2, 3, 4, 3, 2, 1});
    }
}
