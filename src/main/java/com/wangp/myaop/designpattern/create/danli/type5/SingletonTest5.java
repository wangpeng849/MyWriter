package com.wangp.myaop.designpattern.create.danli.type5;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 14:50
 *
 */
public class SingletonTest5 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}
//懒汉式
//双重检查


/**
 * 优缺点说明:
 *推荐使用这种方式
 */
class Singleton{
    //1.构造方法私有化
    private Singleton(){}

    //2.本类内部创建实例
    private static volatile Singleton instance;

    //3.提供静态公有方法，在使用时，再去创建，即懒汉式
    // 加入同步代码块
    public static  Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){  //这句注释就是原第五种
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}