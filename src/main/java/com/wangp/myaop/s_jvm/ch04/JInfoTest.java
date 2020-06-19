package com.wangp.myaop.s_jvm.ch04;

import java.util.Map;

/**
 * @Author wangp
 * @Date 2020/6/18
 * @Version 1.0
 */
public class JInfoTest {
    public static void main(String[] args) {
        while(true){
            byte[] b = null;
            for (int i = 0; i < 10; i++) {
                b = new byte[1*2024*1024];
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                //getAllStackTraces 代替 jstack
                Map<Thread, StackTraceElement[]> threadMap = Thread.getAllStackTraces();
                for(Map.Entry<Thread,StackTraceElement[]> entry:threadMap.entrySet()){
                    Thread t = entry.getKey();
                    StackTraceElement[] ss = entry.getValue();
                    System.out.println(t.getName() + "-" + t.getId());
                    for (StackTraceElement s : ss) {
                        System.out.println(s);
                    }
                }
            }
        }
    }

    //jinfo -flag +PrintGCDetails port
    //打开GC详情

    //jmap 内存堆转储
    //jmap -dump:live,format=b,file=heap.bin

    //jhat 分析 jmap 产生的文件  localhost:7000访问  (功能不够强)

    //jstack Java堆栈跟踪工具

    //jConsole  监控与管理控制台
    //管理远程进程
    //-Djava.rmi.server.hostname=
    //-Dcom.sun.management.jmxremote
    //-Dcom.sun.management.port=8888
    //-Dcom.sun.management.authenticate=false
    //-Dcom.sun.management.ssl=false

    //VisualVM 多合一故障处理工具
    //插件中心 http://visualvm.github.io/
}
