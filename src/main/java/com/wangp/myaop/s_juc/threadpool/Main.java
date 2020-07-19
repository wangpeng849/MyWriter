package com.wangp.myaop.s_juc.threadpool;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/7/19 9:51
 */
public class Main {
    //直接创建线程时：
    //1.反复创建线程开销大
    //2.过多的线程会占用太多内存

    //使用线程池：
    //1.加快响应速度
    //2.合理利用CPU和内存
    //3.统一管理

    //创建线程数参数：
    //corePoolSize 核心线程数
    //maxPoolSize 最多线程数
    //keepAliveTime 保持存活时间
    //workQueue  任务存储队列
    //threadFactory 用来创建线程
    //handler 拒绝策略
    //小于corePoolSize 创建线程
    //小于workQueue容量，放入队列
    //大于workQueue容器，开启maxPoolSize线程
    //再大拒绝

    //停止线程池
    //shutdown 初始化整个关闭过程 把正在执行的完成，新任务拒绝
    //terminated 是否关闭

    //线程池状态
    //1、RUNNING
    //
    //(1) 状态说明：线程池处在RUNNING状态时，能够接收新任务，以及对已添加的任务进行处理。
    //(02) 状态切换：线程池的初始化状态是RUNNING。换句话说，线程池被一旦被创建，就处于RUNNING状态，并且线程池中的任务数为0！
    //
    //private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    //
    //2、 SHUTDOWN
    //
    //(1) 状态说明：线程池处在SHUTDOWN状态时，不接收新任务，但能处理已添加的任务。
    //(2) 状态切换：调用线程池的shutdown()接口时，线程池由RUNNING -> SHUTDOWN。
    //
    //3、STOP
    //
    //(1) 状态说明：线程池处在STOP状态时，不接收新任务，不处理已添加的任务，并且会中断正在处理的任务。
    //(2) 状态切换：调用线程池的shutdownNow()接口时，线程池由(RUNNING or SHUTDOWN ) -> STOP。
    //
    //4、TIDYING
    //
    //(1) 状态说明：当所有的任务已终止，ctl记录的”任务数量”为0，线程池会变为TIDYING状态。当线程池变为TIDYING状态时，会执行钩子函数terminated()。terminated()在ThreadPoolExecutor类中是空的，若用户想在线程池变为TIDYING时，进行相应的处理；可以通过重载terminated()函数来实现。
    //(2) 状态切换：当线程池在SHUTDOWN状态下，阻塞队列为空并且线程池中执行的任务也为空时，就会由 SHUTDOWN -> TIDYING。
    //当线程池在STOP状态下，线程池中执行的任务为空时，就会由STOP -> TIDYING。
    //
    //5、 TERMINATED
    //
    //(1) 状态说明：线程池彻底终止，就变成TERMINATED状态。
    //(2) 状态切换：线程池处在TIDYING状态时，执行完terminated()之后，就会由 TIDYING -> TERMINATED。
}
