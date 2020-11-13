package com.wangp.myaop.leetcode.simple;


import java.util.Arrays;

/**
 * <pre>
 * classname SortArrayByParityII
 * description
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/12 20:32
 **/
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
//        int len = A.length;
//        int jIndex = 1;
//        int oIndex = 0;
//        int[] res = new int[len];
//        for (int i : A) {
//            if (i % 2 == 1) {
//                res[jIndex] = i;
//                jIndex += 2;
//            } else {
//                res[oIndex] = i;
//                oIndex += 2;
//            }
//        }
//        return res;
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 != 0) {
                while (A[j] % 2 != 0) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    /***
     * 统计一个数字在排序数组中出现的次数。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
//        int count = 0;
//        for (int num : nums) {
//            if (target == num) {
//                count++;
//            }
//        }
//        return count;
        if (nums.length == 0) {
            return 0;
        }
        //初始左右指针位置
        int i = 0;
        int j = nums.length - 1;
        //第一次二分：找right边界
        //这边是“小于等于”，因此当循环结束后，ij不重合，且如果存在target值的话，i的位置就是右边界（target值序列右边第一个大于target值的位置），因为最后一次循环一定是i=mid+1；且此时j指向target
        while (i <= j) {
            int mid = (i + j) >> 1;
            //这里是“小于等于”，目的是为了确定右边界，就是说当mid等于target时，因为不确定后面还有没有target，所以同样需要左边收缩范围
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        //在更新right边界值之前，需要判断这个数组中是否存在target，如果不存在（看j指向的位置是不是target，为什么看的是j指针？详见上面的注释）
        if (j >= 0 && nums[j] != target) {
            return 0;
        }
        int right = i;    //更新right边界
        //重置指针
        i = 0;
        j = nums.length - 1;
        //第二次二分：找left边界
        //结束之后，j指向target序列左边第一个小于它的位置，i指向target（经过上面判断，target一定存在）
        while (i <= j) {
            int mid = (i + j) >> 1;
            //这里是“大于等于”，目的是确定左边界，因为就算当mid等于target的时候，因为不确定左边还有没有target，所以同样需要收缩右边界
            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        //更新左指针
        int left = j;
        return right - left - 1;
    }


    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArrayByParityII().sortArrayByParityII(new int[]{4, 2, 5, 7})));
        System.out.println(new SortArrayByParityII().search(new int[]{5, 7, 8, 8, 8, 9}, 8));
    }
}
