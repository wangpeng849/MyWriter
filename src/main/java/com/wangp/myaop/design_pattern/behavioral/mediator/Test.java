package com.wangp.myaop.design_pattern.behavioral.mediator;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 11:23
 **/
public class Test {

    public static void main(String[] args) {
        User wang = new User("wang");
        wang.sendMessage("hello peng,you are good");
        User peng = new User("peng");
        peng.sendMessage("hello wang,I am fine");
    }
}
