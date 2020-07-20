package com.wangp.myaop.designpattern.create.danli.type1;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 14:50
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}
//饿汉式（静态变量）

/**
 * 饿汉式(静态常量)优缺点说明:
 * 1)优点:这种写法比较简单,就是在类装载的时候就完成实例化。避免了线程同步问题
 * 2)缺点:在类装载的时候就完成实例化,没有达到 Lazy loading的效果。如果从始至终从未使用过这个实例,则会造成内存的浪费
 * 3)这种方式基于 classloader机制避免了多线程的同步问题,不过, Instance在类装载时就实例化,在单例模式中大多数都是调用 getinstance方法,
 *   但是导致类装载的原因有很多种,因此不能确定有其他的方式(或者其他的静态方法)导致类装载,这时候初始化 instance就没有达到 lazy loading的效果
 * 4)结论:这种单例模式可用,可能造成内存浪费
 */
class Singleton{
    //1.构造方法私有化
    private Singleton(){}

    //2.本类内部创建实例
    private final static Singleton instance = new Singleton();

    //3.提供静态公有方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}