package com.wangp.myaop.designpattern.create.yuanxing.improve;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/4 18:21
 */

public class Client {
    /**
     * 1)原型模式( Prototype模式)是指:
     * 用原型实例指定创建对象的种类,并且通过拷贝这些原型,创建新的对象
     * 2)原型模式是一种创建型设计模式,允许一个对象再创建另外一个可定制的对象,无需知道如何创建的细节
     * 3)工作原理是:通过将一个原型对象传给那个要发动创建的对象,这个要发动创建的对象通过请求原型对象拷贝它们自己来实施创建,即对象, clone
     * 4)形象的理解:孙大圣技出猴毛,变出其它孙大圣
     */
    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom",1,"白色","西藏羊");
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
       //...
        Sheep sheep10 = (Sheep) sheep.clone();
        System.out.println(sheep);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep10);
        System.out.println("(sheep's hashCode == sheep2's hashCode)="+(sheep.hashCode()==sheep2.hashCode()));
        System.out.println("sheep2 == sheep3  --> " + (sheep2 == sheep3));
    }
}
