package com.wangp.myaop.s_jvm.ch04;

import java.util.Arrays;

/**
 * @Author wangp
 * @Date 2020/6/17
 * @Version 1.0
 */
public class Stack {
    public Object[] elements;
    private int size = 0;

    private static final int cap = 16;

    public Stack(){
        elements = new Object[cap];
    }

    public void push(Object e){
        elements[size] = e;
        size++;
    }

    public Object pop(){
        Object o = elements[--size];
        elements[size] = null; //防止内存泄漏
        return o;
    }

    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length==0) return -1;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]<0){
                dp[i] = nums[i];
            }else{
                dp[i] = dp[i-1] + nums[i];
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
