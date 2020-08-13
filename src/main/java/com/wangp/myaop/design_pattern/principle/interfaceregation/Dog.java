package com.wangp.myaop.design_pattern.principle.interfaceregation;

/**
 * <pre>
 * classname Dog
 * description
 * </pre>
 * <p>
 * 实现了接口隔离
 *
 * @author wangp
 * @date 2020/8/9 18:54
 **/
public class Dog implements IEatAnimalAct, ISwimAnimalAct {


    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}
