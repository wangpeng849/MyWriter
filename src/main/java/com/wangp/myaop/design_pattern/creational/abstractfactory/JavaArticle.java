package com.wangp.myaop.design_pattern.creational.abstractfactory;

/**
 * <pre>
 * classname JavaArticle
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/12 20:30
 **/
public class JavaArticle extends Article {

    @Override
    public void produce() {
        System.out.println("Java 手记");
    }
}
