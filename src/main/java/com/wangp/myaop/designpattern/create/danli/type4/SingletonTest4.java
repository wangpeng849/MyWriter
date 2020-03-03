package com.wangp.myaop.designpattern.create.danli.type4;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 14:50
 */
public class SingletonTest4 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}
//懒汉式


/**
 * 优缺点说明:
 * 1)解决了线程不安全问题
 * 2)效率太低了,每个线程在想获得类的实例时候,执行 getinstance(方法都要进行同步。而其实这个方法只执行一次实例化代码就够了,后面的想获得该类实例直接 returne就行了。方法进行同步效率太低
 * 3)结论:在实际开发中,不推荐使用这种方式
 */
class Singleton{
    //1.构造方法私有化
    private Singleton(){}

    //2.本类内部创建实例
    private static Singleton instance;

    //3.提供静态公有方法，在使用时，再去创建，即懒汉式
    // 加入同步代码块
    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}