package com.wangp.myaop.s_algorithm.dynamic_programming;

/**
 * @Author wangp
 * @Date 2020/6/9
 * @Version 1.0
 */
public class Knapsack {
    /**
     * 0-1背包问题
     * <p>
     * n件物品和最大承重W的背包 每件物品的重量是wi、价值是vi
     * 在不超过W的前提下，背包的最大价值
     */
    public static void main(String[] args) {
        int weight[] = {2, 2, 6, 5, 4};
        int value[] = {6, 3, 5, 4, 6};
        int capacity = 10;
        System.out.println(maxValue(weight, value, capacity));
    }

    static int maxValue(int[] weights, int[] values, int capacity) {
        /*
            编号为k的物品 价值是values[k] 重量是weights[k]

            dp(i,j)是最大承重为j ， 有前i件物品的最大价值  i∈[0,n)  j∈[0,W]
            dp(3,7)是最大承重为7 ， 有前3件物品的最大价值

            最终解为 dp(n,capacity)
            dp(i,0)、dp(0,j)初始值均为0

            如果j<weights[i], dp(i,j) = dp(i-1,j)

            如果不选择第i件物品 dp(i,j) = dp(i-1,j)
            如果选择第i件物品 dp(i,j) = values[i] + dp(i-1,j-weight[i])
            dp(i,j) = Max{  dp(i-1,j) , values[i] + dp(i-1,j-weight[i])}
         */
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (values.length != weights.length || capacity <= 0) return 0;
        int[][] dp = new int[weights.length + 1][capacity + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i-1][j],
                            dp[i-1][j-weights[i-1]]+values[i-1]
                    );
                }
            }
        }
        return dp[weights.length][capacity];
    }
}
