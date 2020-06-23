package com.wangp.myaop.s_jvm.ch05;

/**
 * @Author wangp
 * @Date 2020/6/23
 * @Version 1.0
 */
public class Exercise {

    static void print(Exercise e1,Exercise e2){
        System.out.println(e1 == (e1=e2));
    }

    public static void main(String[] args) {
        Exercise e1 = new Exercise();
        Exercise e2 = new Exercise();
        print(e1,e2);
    }
}
