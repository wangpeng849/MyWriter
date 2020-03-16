package com.wangp.myaop.designpattern.create.danli.type2;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 14:50
 */
public class SingletonTest2 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}

/**
 * 饿汉式(静态常量)优缺点说明:
 * 1)这种方式和上面的方式其实类似,只不过将类实例化的过程放在了静态代码块中,
 *   也是在类装载的时候,就执行静态代码块中的代码,初始化类的实例。优块点和上面是一样的
 * 2)结论:这种单例模式可用,但是可能造成内存溴费
 */
class Singleton{
    //1.构造方法私有化
    private Singleton(){}

    //2.本类内部创建实例
    private static Singleton instance;

    static { //在静态代码块中创建单例对象
        instance = new Singleton();
    }
    //3.提供静态公有方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}