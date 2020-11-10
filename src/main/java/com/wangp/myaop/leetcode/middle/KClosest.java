package com.wangp.myaop.leetcode.middle;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <pre>
 * classname KClosest
 * description
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/10 19:52
 **/
public class KClosest {

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));
        return Arrays.copyOfRange(points, 0, K);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new KClosest().kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }
}
