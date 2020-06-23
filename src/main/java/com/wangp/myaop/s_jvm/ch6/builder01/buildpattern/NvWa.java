package com.wangp.myaop.s_jvm.ch6.builder01.buildpattern;

import com.wangp.myaop.s_jvm.ch6.builder01.buildpattern.product.Person;

/**
 * @Author wangp
 * @Date 2020/6/23
 * @Version 1.0
 */
public class NvWa {
    public Person buildPerson(PersonBuilder builder){
        builder.buildHead();
        builder.buildBody();
        builder.buildFoot();
        return builder.createPerson();
    }
}
