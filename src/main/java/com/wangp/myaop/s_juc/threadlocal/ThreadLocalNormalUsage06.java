package com.wangp.myaop.s_juc.threadlocal;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/7/19 19:25
 *
 * 全局变量
 */
public class ThreadLocalNormalUsage06 {
    public static void main(String[] args) {
        new Service1().process();
    }
}

class Service1{
    public void process(){
        User user = new User("name");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}
class Service2{
    public void process(){
        User user  = UserContextHolder.holder.get();
        //remove清空
        UserContextHolder.holder.remove();
        //set又可以重新赋值
        UserContextHolder.holder.set(new User("newName"));
        System.out.println("service2拿到："+user.name);
        new Service3().process();
    }
}

class Service3{
    public void process(){
        User user  = UserContextHolder.holder.get();
        System.out.println("service3拿到："+user.name);
    }
}

class UserContextHolder{
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class User{
    String name;

    public User(String name) {
        this.name = name;
    }
}
