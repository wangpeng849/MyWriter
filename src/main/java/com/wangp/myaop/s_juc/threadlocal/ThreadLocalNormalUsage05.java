package com.wangp.myaop.s_juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/7/19 14:15
 * <p>
 * <p>
 * 线程池执行   利用ThreadLocal
 */
public class ThreadLocalNormalUsage05 {
    static Set set = new HashSet<>();
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    private String date(int seconds) {
        //参数单位是毫秒  是从1970.1.1 00:00:00开始计时
        Date date = new Date(seconds * 1000);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat = ThreadSafeFormatter.simpleDateFormatThreadLocal.get();
        String format = simpleDateFormat.format(date);
        set.add(format);
        return format;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.execute( new Thread(()->{
                String date = new ThreadLocalNormalUsage05().date(finalI);
                System.out.println(date);
            }));
        }
        Thread.sleep(5000);
        System.out.println("size="+set.size());
    }
}
class ThreadSafeFormatter{
    public static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
}
