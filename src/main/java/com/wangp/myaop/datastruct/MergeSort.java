package com.wangp.myaop.datastruct;

import java.util.Arrays;

/**
 * @Author wangp
 * @Date 2020/4/24
 * @Version 1.0
 * <p>
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 6, 9, 8, 7, 4, 5, 3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int t  = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[t++] = arr[i++];
        }
        while (j<=right){
            temp[t++] = arr[j++];
        }
        t = 0;
        while(left<=right){
            arr[left++] = temp[t++];
        }
    }
}
