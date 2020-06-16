package com.wangp.myaop.s_jvm.ch02;

/**
 * @Author wangp
 * @Date 2020/6/16
 * @Version 1.0
 */
public class Main {
    /**
         垃圾回收器 & 内存分配策略
            1.引用计数法
                优点：快，方便，实现简单
                缺点：相互引用
            2.可达性分析
                可作为GC Roots的对象包括：
                    1.方法区：类静态属性引用的对象
                    2.方法区：常量引用的对象
                    3.虚拟机栈（本地变量表）中引用的对象
                    4.本地方法栈中引用的对象
                从任一个GC Roots不可达就是可以回收的对象
            3.标记-清除算法
                会产生内存碎片
            4.复制算法
                留一半不用，留一半整理空间
            5标记-整理算法
                将存活的对象放在一边，然后全部清空其他位置



                各种引用：
                a.强引用：
                    Object obj = new Object();
                b.软引用 SoftReference：
                    有用但是并非必需，用软引用关联的对象，系统将要发生OOM之前，这些对象就会被回收
                c.弱引用  WeakReference:
                    有用（程度比软引用更低）但是并非必需，用软引用关联的对象，只能生存到下一次垃圾回收之前，不管内存够不够，这些对象都会被回收
                d.虚引用  PhantomReference:
                    幽灵引用，最弱,被垃圾回收的时候收到一个通知
            软引用和弱引用运用在资源紧张的场景


        新生代：
        Eden + A(存活的) --> B
        Eden + B(存活的) --> A


            垃圾回收期列表：
                并行：同一时刻
                并发：同一时间段


            Serial/Serial Old：最古老的，单线程，独占式，成熟，单CPU
                -XX:+UseSerialGC 新生代和老年代都用串行收集器
                -XX:+UseParNewGC 新生代使用ParNew  老年代使用Serial Old
                -XX:+UseParallelGC 新生代使用ParallelGC  老年代使用Serial Old

            ParNew和Serial唯一区别是：ParNew是多线程，多CPU,其停顿时间比Serial少

            Parallel Scavenge/Parallel Old 关注吞吐量，吞吐量 = 运行用户代码时间/(运行用户代码时间 + 垃圾收集时间)，停顿时间短的适合用户交互的程序，
                -XX:MaxGCPauseMils:控制最大停顿时间 -XX:GCTimeRatio吞吐量的倒数（整数） -XX:+UseAdaptiveSizePolicy 自适应调节 -XX:+useParallelGC  使用 Parallel Old

            Concurrent Mark Sweep (CMS) 关注最短停顿时间
                初始标记 ： 短暂
                并发标记 ： 和用户的应用程序同时进行
                重新标记 ： 短暂
                并发清除 ： 和用户的应用程序同时进行
                -XX:+UseConcMarkSweepGC 新生代使用ParNew  老年代使用CMS


            G1 垃圾回收
                -XX:+UseG1GC
     */
}
