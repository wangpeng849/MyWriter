package com.wangp.myaop.leetcode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/4/21
 * @Version 1.0
 */
public class Solution {

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


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,2,2,1,2,2,1,2,2};
        int i = solution.numberOfSubarrays2(arr, 2);
        System.out.println(i);
    }


    public int numberOfSubarrays2(int[] nums, int k) {
        int preEven=0;
        List<Integer> list=new ArrayList<>();
        for(int i:nums){
            if ((i&1)==0){
                preEven++;
            }else{
                list.add(preEven+1);
                preEven=0;
            }
        }
        list.add(preEven+1);
        // list.forEach(o-> System.out.println(o));
        int count=0;
        for (int i=0;i<list.size()-k;i++){
            count+=(list.get(i)*list.get(i+k));
        }
        return count;
    }

}
