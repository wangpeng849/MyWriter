package com.wangp.myaop.s_jvm.ch01;

import java.nio.ByteBuffer;

/**
 * @Author wangp
 * @Date 2020/6/16
 * @Version 1.0
 */
public class DirectMem {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024 * 14);
        //Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
        //NIO的时候可能出现
    }
}
