package com.wangp.myaop.designpattern.create.danli.type8;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 14:50
 *
 */
public class SingletonTest8 {
    public static void main(String[] args) {
       Singleton singleton = Singleton.INSTANCE;
       Singleton singleton2 = Singleton.INSTANCE;
        System.out.println(singleton == singleton2);

    }
}
//枚举法

/**
 * 优缺点说明:1)这借助DK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题,而且还能防止反序列化重新创建新的对象。
 * 2)这种方式是 Effective Javat作者 Josh Bloch提倡的方式
 * 3)结论:推荐使用
 */
enum Singleton{
    INSTANCE;
}