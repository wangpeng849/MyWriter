package com.wangp.myaop.designpattern.create.yuanxing.objattributeclone;


/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/4 18:42
 */
public class Clinet {

    public static void main(String[] args) {
         Sheep sheep = new  Sheep("tom",1,"白色","China");
         sheep.friend = new Sheep("jack",2,"黑色","China");
         Sheep sheep2 = (Sheep) sheep.clone();
         Sheep sheep3 = (Sheep) sheep.clone();
        //,,,
         Sheep sheep10 = (Sheep) sheep.clone();
        System.out.println(sheep);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep10);
        /**
         * 浅拷贝的介绍
         * 1)对于数据型是基本数据类型的成员变量,浅拷贝会直接进行值传递,也就是将该属任值复制一份给新的对象
         * 2)对于数据类型是引用数据类型的成员变量,比如说成员变量是某个数组、某个类的对象等,那么浅拷贝会进行引用传递,也就是只是将该成员变量的引用值(内存地址)复制一份给新的对象。
         * 因为实际上两个对象的该成员变量都指向同一个实例。在这种情况下,在一个对象中修改该成员变量会影响到另一个对象的该成员变量值
         * 3)前面我们克隆羊就是浅拷贝
         * 4)浅拷贝是使用默认的cone(方法来实现sheep(Sheep) super clone
         */

        /**
         * 深拷贝基本介绍
         * 1)复制对象的所有基本数据类型的成员变量值
         * 2)为所有引用数据类型的成员变量申请存储空间,并复制每个引用数据类型成员变量所引用的对象,直到该对象可达的所有对象,也就是说,对象进行深拷贝要对整个对象进行拷贝
         * 3)深拷贝实现方式1:重写 clone方法来实现深拷贝
         * 4)深拷贝实现方式2:通过对象序列化实现深拷贝
         */
        System.out.println("sheep.friend.hashCode()="+sheep.friend.hashCode());
        System.out.println("sheep2.friend.hashCode()="+sheep2.friend.hashCode());
        System.out.println("sheep.friend == sheep2.friend  -->" + (sheep.friend == sheep2.friend ));
    }
}
