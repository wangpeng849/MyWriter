package com.wangp.myaop.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author farling
 * @Date 2019/11/28
 */
public class MySoluction {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public void reOrderArray(Integer [] array) {
//       int low = 0;
//       int high = array.length-1;
//
//       while(low<high){
//           while(array[high]%2 == 0){
//               high--;
//           }while(array[low]%2 != 0){
//               low++;
//           }
//
//           if(low<high){
//               int temp = array[low];
//               array[low] = array[high];
//               array[high] = temp;
//           }
//       }

//        int index = 0;
//        int flag = 0;
//        for (int i = 0; i < array.length; i++) {
//            if(array[i]%2==0 && flag == 0){
//                index  = i;
//                flag = 1;
//            }
//            if(array[i]%2==1){
//                int temp = array[i];
//                array[i] = array[index];
//                array[index] =temp;
//                index = i;
//                flag = 0;
//            }
//        }

        List oNum = new ArrayList();
        List eNum = new ArrayList();
        for (int i : array) {
            if(i%2==0){
                oNum.add(i);
            }else{
                eNum.add(i);
            }
        }
        List<Integer> resArr = new ArrayList();
        resArr.addAll(eNum);
        resArr.addAll(oNum);
        array = resArr.toArray(new Integer[resArr.size()]);
    }
    public static void main(String[] args) {
        MySoluction mySoluction = new MySoluction();
        Integer arr[] = {1,2,3,4,5,6,7,8,9,10,12};
        mySoluction.reOrderArray(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}


