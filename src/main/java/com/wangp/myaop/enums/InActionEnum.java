package com.wangp.myaop.enums;

/**
 * @Author wangp
 * @Date 2020/4/30
 * @Version 1.0
 */
public class InActionEnum {
    public static void main(String[] args) {
        System.out.println(People.GOOD.equals("GOOD"));//false
        System.out.println(People.GOOD.name().equals("GOOD"));//true
        System.out.println(People.GOOD == People.GOOD);
        System.out.println(People.BAD.getName());
    }
}

enum People{
    GOOD,
    BAD,
    RICH,
    POOR;
    People(){

    }
    public String getName(){
        return this + " invocation a function";
    }
}
