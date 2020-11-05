package com.wangp.myaop.leetcode.middle;

/**
 * <pre>
 * classname MaxIncreaseKeepingSkyline
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/5 20:25
 **/
public class MaxIncreaseKeepingSkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] h = new int[grid[0].length];
        int[] d = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int max = grid[i][0];
            for (int j = 1; j < grid.length; j++) {
                max = Math.max(max, grid[i][j]);
            }
            d[i] = max;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int max = grid[0][i];
            for (int j = 1; j < grid[0].length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            h[i] = max;
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += Math.min(d[i], h[j]) - grid[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        new MaxIncreaseKeepingSkyline()
                .maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}});
    }
}
