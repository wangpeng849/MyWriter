package com.wangp.myaop.s_jvm.ch01;

/**
 * @Author wangp
 * @Date 2020/6/15
 * @Version 1.0
 */
public class SimpleHeap {

    private int id;

    public SimpleHeap(int id) {
        this.id = id;
    }

    public void print(){
        System.out.println("My id is " + id);
    }

    public static void main(String[] args) {
        SimpleHeap s1 = new SimpleHeap(1);
        SimpleHeap s2 = new SimpleHeap(2);
        s1.print();
        s2.print();
        //栈中有两个 s1,s2 变量指向堆中 s1,s2 的实例 在方法区实现其方法
    }
}
