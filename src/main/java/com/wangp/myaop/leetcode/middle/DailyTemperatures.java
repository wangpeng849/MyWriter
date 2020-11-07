package com.wangp.myaop.leetcode.middle;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * classname DailyTemperatures
 * description
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/6 19:10
 **/
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {

        //执行用时：1743 ms, 在所有 Java 提交中击败了5.01%的用户
        //内存消耗：46.8 MB, 在所有 Java 提交中击败了28.86%的用户

//        int len = T.length;
//        int[] res = new int[len];
//        for (int i = 0; i < len; i++) {
//            int days = 1;
//            for (int j = i + 1; j < len; j++) {
//                if (T[i] < T[j]) {
//                    res[i] = days;
//                    break;
//                } else {
//                    days++;
//                }
//                if (j == len - 1) {
//                    res[i] = 0;
//                }
//            }
//        }
//        return res;

        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] res = new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(res));
    }
}
