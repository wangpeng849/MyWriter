package com.wangp.myaop.designpattern.create.gongchang;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 15:39
 */

import org.springframework.data.mongodb.util.BsonUtils;

import java.util.Calendar;

/**
 * 看一个具体的需求看一个技萨的项目:要便于披萨种类的扩展,要便于维护
 * 1)披产的种类很多(比如 Greekpizz、 Cheesepizz等)
 * 2)披萨的制作有 prepare,bake,cut,box)完成技萨店订购功能。
 */
public class Info {

    public static void main(String[] args) {
        /**
         *  JDK源码使用的工厂模式
         */
        Calendar cal  = Calendar.getInstance();
        //月份从0开始 需要取+1月份
    }
}
