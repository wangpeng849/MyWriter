package com.wangp.myaop.s_jvm.ch6.builder01.buildpattern;

import com.wangp.myaop.s_jvm.ch6.builder01.buildpattern.product.Person;
import com.wangp.myaop.s_jvm.ch6.builder01.buildpattern.product.Woman;

/**
 * @Author wangp
 * @Date 2020/6/23
 * @Version 1.0
 */
public class WoManBuilder extends PersonBuilder {

    private Person person;

    public WoManBuilder() {
        super();
        this.person = new Woman();
    }

    @Override
    public void buildHead() {
        person.setHead("Pretty Head");
    }

    @Override
    public void buildBody() {
        person.setBody("Soft body");
    }

    @Override
    public void buildFoot() {
        person.setFoot("long white foot");
    }

    @Override
    public Person createPerson() {
        return person;
    }
}
