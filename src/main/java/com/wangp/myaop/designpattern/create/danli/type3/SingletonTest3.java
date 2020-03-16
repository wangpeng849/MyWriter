package com.wangp.myaop.designpattern.create.danli.type3;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 14:50
 */
public class SingletonTest3 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}
//懒汉式


/**
 * 优缺点说明
 * 1)起到了 Lazy Loading的效果,但是只能在单线程下使用
 * 2)如果在多线程下,一个线程进入了计{ singleton=nu判断语句块,还未来得及住下执行,另一个线程也通过了这个判断语句,这时便会产生多个实例。所以在多线程环境下不可使用这种方式
 * 3)结论:在实际开发中,不要使用这种方式
 */
class Singleton{
    //1.构造方法私有化
    private Singleton(){}

    //2.本类内部创建实例
    private static Singleton instance;

    //3.提供静态公有方法，在使用时，再去创建，即懒汉式
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}