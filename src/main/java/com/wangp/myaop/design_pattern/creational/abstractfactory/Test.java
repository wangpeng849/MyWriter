package com.wangp.myaop.design_pattern.creational.abstractfactory;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/12 20:33
 **/
public class Test {

    public static void main(String[] args) {
        CourseFactory factory = new JavaCourseFactory();
        factory.getVideo().produce();
        factory.getArticle().produce();
    }
}
