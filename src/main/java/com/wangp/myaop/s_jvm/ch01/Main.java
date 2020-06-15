package com.wangp.myaop.s_jvm.ch01;

/**
 * @Author wangp
 * @Date 2020/6/15
 * @Version 1.0
 */
public class Main {
    /**
        1.程序计数器
            当前程序语句执行到哪一行
        2.虚拟机栈
            线程私有，方法的执行就对应者栈帧在虚拟机栈中的出栈和入栈
        3.本地方法栈
            保存native方法的信息
        4.Java堆
            几乎所有的对象都在堆上分配。 -Xms 堆的最小值;-Xmx 堆的最大值;-Xmn 新生代的大小;-XXNewSize 新生代的最小值; -XX:MaxNewSize 新生代的最大值
        5.方法区（1.8移出去 为元空间）
            也叫永久区，jdk 7及以前： -XX:PermSize -XX:MAxPermSize
                        jdk 7 以后： -XX:MetaspaceSize -XX:MAxMetaspaceSize
            运行时常量池 --> 1.7 方法区的一部分  1.8在堆中

         直接内存
            部署虚拟机运行时数据区的一部分，也不是java虚拟机规范中定义的内存区域   MaxDirectMemorySize可以设置直接内存大小



        Java内存区域：
            线程共享内存区：Java堆，方法区
            线程私有内存区：虚拟机栈，本地方法栈，程序计数器
     */
}
