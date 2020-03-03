package com.wangp.myaop.collection;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/2/19 14:24
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        /**
         *  arrayList 的删除和新增都用到了
         *  arraycopy(Object src,  int  srcPos,
         *            Object dest, int destPos,
         *            int length);
          */
        int[] srcArr = {0,1,2,3,4,5,6,7,8,9};
        int[] destArr = new int[10];
        System.arraycopy(srcArr,3,destArr,6,4);
        for (int i : destArr) {
            System.out.print(i + ",");  //0,0,0,0,0,0,3,4,5,6,
        }
        //删除5的操作
        System.out.println("\n删除5的操作");
        System.arraycopy(srcArr,6,srcArr,5,srcArr.length-6);
        srcArr[srcArr.length-1] = 0;
        for (int i : srcArr) {
            System.out.print(i + ",");
        }
    }
}

