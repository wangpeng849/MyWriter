package com.wangp.myaop.s_jvm.ch05;

/**
 * @Author wangp
 * @Date 2020/6/19
 * @Version 1.0
 */
public class Main {
    //类加载机制
    //有且只有5中情况才必须对类进行初始化
    // 1.new,getstatic,putstatic,invokestatic
    // 2.对类进行反射调用
    // 3.初始化一个类，但是父类还没有初始化的时候，先触发父类的
    // 4.指定一个执行main的类，初始化主类
    // 5.动态语言支持


    //类加载器
    //三件事：
    // 1.加载类的二进制流
    // 2.把静态存储结构转换为方法去的运行时结构
    // 3.生成一个代表这个类的Class对象


    //双亲委派模型
    //先交由父类执行，如果父类可以完成对类的加载，就直接返回。保证java稳定性


    //Tomcat类加载机制
    //
}
