package com.wangp.myaop.leetcode.hard;

/**
 * <pre>
 * classname Trap
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/2 17:51
 **/
public class Trap {

    public int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j <= height.length - 1; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        new Trap().trap(new int[]{4, 2, 0, 3, 2, 5});
    }
}
