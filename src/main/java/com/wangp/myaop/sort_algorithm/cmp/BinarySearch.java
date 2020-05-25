package com.wangp.myaop.sort_algorithm.cmp;

/**
 * @Author wangp
 * @Date 2020/5/21
 * @Version 1.0
 */
public class BinarySearch {
    //二分查找

    /**
     * 查找有序数组中v所在的位置
     *
     * @param array
     * @param v
     * @return
     */
    public static int indexOf(int[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (array[mid] == v) {
                return mid;
            }
            if (array[mid] < v) {
                begin = mid + 1;

            }
            if (array[mid] > v) {
                end = mid;
            }
        }
        return -1;
    }


    //二分查找 优化

    /**
     * 查找v在有序数组插入位置
     *
     * @return
     */
    public static int search(int[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if(v < array[mid]){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }
        return begin;//或者 return end
    }

    public static void main(String[] args) {
        int i = indexOf(new int[]{1, 2, 3, 3, 5, 6}, 3);
        System.out.println(i);
    }
}

