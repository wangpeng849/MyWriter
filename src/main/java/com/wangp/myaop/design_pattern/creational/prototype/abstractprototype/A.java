package com.wangp.myaop.design_pattern.creational.prototype.abstractprototype;

/**
 * <pre>
 * classname A
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/17 19:40
 **/
public class A implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
