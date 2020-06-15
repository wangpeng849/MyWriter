package com.wangp.myaop.s_jvm.ch01;

/**
 * @Author wangp
 * @Date 2020/6/15
 * @Version 1.0
 */
public class StackAlloc {
    public static class User {
        public int id = 0;
        public String name = "";
    }

    public static void alloc() {
        User u = new User();
        u.id = 5;
        u.name = "wangp";
    }

    /**
     * -server JVM运行的服务器模式，只有这种模式才能逃逸分析  -mix 混合模式 -client
     * -Xmx10m -Xms10m 堆的最小和最大值
     * -XX:  + 表示开始功能  -表示关闭功能
     * -XX:+DoEscapeAnalysis 是否启用逃逸分析   逃逸分析：对象是否仅作用在方法体内，是的话就不逃逸
     * -XX:+PrintGC 打印GC日志
     * -XX:+EliminateAllocations 标量替换  将类的属性设置为局部变量
     * -XX:-UseTLAB  -> TLAB ThreadLocalAllocBuffer线程本地分配缓存  事先在堆里面为每个线程分配一块私有内存
     */
    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 1_0000_0000; i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println((e - b) + "ms");
    }

}
