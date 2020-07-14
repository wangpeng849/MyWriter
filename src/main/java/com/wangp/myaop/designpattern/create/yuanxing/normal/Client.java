package com.wangp.myaop.designpattern.create.yuanxing.normal;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/4 18:16
 */
public class Client {
    public static void main(String[] args) {
        //传统方法
        //传统的方式的优缺点
        // 1)优点是比较好理解,简单易操作。
        // 2)在创建新的对象时,总是要重新获取原始对象的属性,如果创建的对象比较复杂时,效率较低
        // 3)总是需要重新初始化对象,而不是动态地获得对象运行时的状态,不够灵活
        // 4)改进的思路分析思路:Java中bjec类是所有类的根类,
        // Object:类提供了一个 clone()方法,该方法可以将一个ava对象复一份,
        // 但是需要实现 clonee的Java类必须要实现一个接口 Cloneable,
        // 该接口表示该类能够复制且具有复制的能力=>原型模式
        Sheep sheep = new Sheep("tom",1,"白色");
        Sheep sheep2 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        Sheep sheep3 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        //,,,
        Sheep sheep10 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());

    }
}
