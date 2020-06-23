package com.wangp.myaop.s_jvm.ch6.builder01.buildpattern;

import com.wangp.myaop.s_jvm.ch6.builder01.buildpattern.product.Man;
import com.wangp.myaop.s_jvm.ch6.builder01.buildpattern.product.Person;

/**
 * @Author wangp
 * @Date 2020/6/23
 * @Version 1.0
 */
public class ManBuilder extends PersonBuilder {

    private Person person;

    public ManBuilder() {
        super();
        this.person = new Man();
    }

    @Override
    public void buildHead() {
        person.setHead("Brave Head");
    }

    @Override
    public void buildBody() {
        person.setBody("Strong body");
    }

    @Override
    public void buildFoot() {
       person.setFoot("powerful foot");
    }

    @Override
    public Person createPerson() {
        return person;
    }
}
