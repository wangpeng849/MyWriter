package com.wangp.myaop.leetcode.simple;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <pre>
 * classname GetLeastNumbers
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/10 20:25
 **/
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
//        Arrays.sort(arr);
//        return Arrays.copyOfRange(arr,0,k);

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new GetLeastNumbers().getLeastNumbers(new int[]{1, 23, 4, 5, 6, 7, 5, 7}, 3)));
    }
}
