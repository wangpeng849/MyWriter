package com.wangp.myaop.leetcode.simple;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * <pre>
 * classname CanFormArray
 * description
 *
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
 * 请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 *
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-array-formation-through-concatenation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/5 17:31
 **/
public class CanFormArray {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = Maps.newHashMap();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        // 对单个 piece 数组，遍历对比
        for (int i = 0; i < arr.length; ) {
            int curVal = arr[i];
            if (map.containsKey(curVal)) {
                int[] piece = map.get(curVal);
                for (int value : piece) {
                    if (arr[i] == value) {
                        i++;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new CanFormArray().canFormArray(new int[]{1, 2, 3, 5}, new int[][]{{1, 2}, {5}, {3}});
    }
}
