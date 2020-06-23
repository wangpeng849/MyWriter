package com.wangp.myaop.s_jvm.ch6.builder01.buildpattern;

import com.wangp.myaop.s_jvm.ch6.builder01.buildpattern.product.Person;

/**
 * 类说明：客户端
 */
public class Mingyun {

    public static void main(String[] args) {
        System.out.println("Create NvWa");
        NvWa nvWa = new NvWa();
        Person man = nvWa.buildPerson(new ManBuilder());
        Person woman = nvWa.buildPerson(new WoManBuilder());
        System.out.println("man = " + man + ",woman = " + woman);
    }
}
