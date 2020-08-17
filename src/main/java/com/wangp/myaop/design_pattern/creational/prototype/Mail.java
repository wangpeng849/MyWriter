package com.wangp.myaop.design_pattern.creational.prototype;

import lombok.Data;

/**
 * <pre>
 * classname Mail
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/17 19:24
 **/
@Data
public class Mail implements Cloneable {

    private String name;
    private String emailAddress;
    private String content;

    public Mail() {
        System.out.println("Mail Class Constructor");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone mail Object");
        return super.clone();
    }
}
