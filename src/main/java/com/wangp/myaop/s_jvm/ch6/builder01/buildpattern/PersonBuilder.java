package com.wangp.myaop.s_jvm.ch6.builder01.buildpattern;

import com.wangp.myaop.s_jvm.ch6.builder01.buildpattern.product.Person;

/**
 * @Author wangp
 * @Date 2020/6/23
 * @Version 1.0
 */
//抽象建造者
public abstract class PersonBuilder {
    public abstract void buildHead();
    public abstract void buildBody();
    public abstract void buildFoot();

    public abstract Person createPerson();
}
