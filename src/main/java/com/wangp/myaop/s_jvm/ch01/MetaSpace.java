package com.wangp.myaop.s_jvm.ch01;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/6/15
 * @Version 1.0
 */
public class MetaSpace {

    //Error occurred during initialization of VM
    //MaxMetaspaceSize is too small.
    public static void main(String[] args) {
        List<Object> list = new LinkedList<>();
        int i = 0;
        while (true) {
            i++;
            if (i % 10000 == 0) System.out.println("i = " + i);
            list.add(new Object());
        }
    }
}
