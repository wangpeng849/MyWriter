package com.wangp.myaop.designpattern.sevenprinciple;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/2 9:47
 *
 * 依赖倒置原则
 *
 *      1)高层模块和应低晨模热,二者都应该依赖其抽象
 *      2)拍象不应该依糗细节,细节应该依模拍象
 *      3)依赖倒转(倒置)的中心思想是面向接口编程
 *      4)依赖倒转原则是基于这样的设计理念:相对于细节的多变性,抽象的东西要稳定的多,
 *      以抽象为基础搭建的架构比以细节为基磁的架构要稳定的多,在java中,抽象指的是接口或抽象类,细节就是具体的实现类
 *      5)使用接口或抽象类的目的是制定好规范,而不涉及任何具体的操作,把现细节的任务交给他们的实现类去完成
 */
public class DependeceInversionPrinciple2 {
    public static void main(String[] args) {
        Person2 person = new Person2();
        person.receive(new Email2());
        person.receive(new Weixin());
    }
}

interface IReceiver{
    public String getInfo();
}

//完成一个person接受消息的功能
class Email2 implements IReceiver{
    public String getInfo(){
        return "电子邮件信息：hello world!";
    }
}
class Weixin implements IReceiver{
    public String getInfo(){
        return "微信：hello world!";
    }
}

//方式1分析：
//  1.新增微信 客户端不用修改
class Person2{
    public void receive(IReceiver receiver){
        System.out.println(receiver.getInfo());
    }
}
