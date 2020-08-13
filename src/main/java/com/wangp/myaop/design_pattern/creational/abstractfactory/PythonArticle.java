package com.wangp.myaop.design_pattern.creational.abstractfactory;

/**
 * <pre>
 * classname PythonArticle
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/12 20:33
 **/
public class PythonArticle extends Article {

    @Override
    public void produce() {
        System.out.println("python 手记");
    }
}
