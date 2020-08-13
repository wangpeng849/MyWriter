package com.wangp.myaop.design_pattern.creational.abstractfactory;

/**
 * <pre>
 * classname JavaCourseFactory
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/12 20:29
 **/
public class JavaCourseFactory implements CourseFactory {

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
