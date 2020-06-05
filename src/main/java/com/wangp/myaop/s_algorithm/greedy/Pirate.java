package com.wangp.myaop.s_algorithm.greedy;

import java.util.Arrays;

/**
 * @Author wangp
 * @Date 2020/6/4
 * @Version 1.0
 */
public class Pirate {

    public static void main(String[] args) {
        int[] weights = {3, 5, 6, 10, 7, 14, 2, 11};
        Arrays.sort(weights);
        int capacity = 30, weight = 0,count=0;
        for (int value : weights) {
            int newWeight = weight + value;
            if (newWeight <= capacity) {
                weight = newWeight;
                count++;
                System.out.println(value);
            }
        }
        System.out.println("一共选了"+ count +"件古董");
    }
}
