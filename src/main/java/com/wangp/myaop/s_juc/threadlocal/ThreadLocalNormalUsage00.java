package com.wangp.myaop.s_juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/7/19 14:15
 *
 *
 * 两个线程打印日期
 */
public class ThreadLocalNormalUsage00 {

        private String date(int seconds){
            //参数单位是毫秒  是从1970.1.1 00:00:00开始计时
            Date date = new Date(seconds * 1000);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.format(date);
        }

    public static void main(String[] args) {
        new Thread(()->{
            String date = new ThreadLocalNormalUsage00().date(10);
            System.out.println(date);
        }).start();
        new Thread(()->{
            String date = new ThreadLocalNormalUsage00().date(104707);
            System.out.println(date);
        }).start();
    }
}
