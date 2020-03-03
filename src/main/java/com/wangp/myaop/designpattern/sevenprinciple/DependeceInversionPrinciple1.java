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
public class DependeceInversionPrinciple1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

//完成一个person接受消息的功能
class Email{
    public String getInfo(){
        return "电子邮件信息：hello world!";
    }
}

//方式1分析：
//  1.简单
//  2.如果我们要获取的对象是 微信，短信等等，则需要新增类，同时person也要新增方法
//  3.解决思路： 新增接口 IReceiver,表示接受者，让Person类与接口IReceiver发生依赖  这样实现依赖倒置原则
class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }
}
