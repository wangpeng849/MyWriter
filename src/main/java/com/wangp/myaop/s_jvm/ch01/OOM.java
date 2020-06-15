package com.wangp.myaop.s_jvm.ch01;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/6/15
 * @Version 1.0
 */
public class OOM {

    public static void main(String[] args) {
//        List<Object> list = new LinkedList<>();
//        int i = 0;
//        while (true) {
//            i++;
//            if (i % 10000 == 0) System.out.println("i = " + i);
//            list.add(new Object());
//        }

        //----以上报错      Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
        //                  GC次数超过限制
        //      此类异常 说明某个循环里再不停的分配对象，但是分配太多，把堆撑爆了

        String[] strings = new String[1_0000_0000];

        //以上报错  Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        //          超过heap空间
        //      此类异常 说明分配了一个大对象
    }
}
