package com.wangp.myaop.design_pattern.creational.abstractfactory;

/**
 * <pre>
 * classname PythonCourseFactory
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/12 20:32
 **/
public class PythonCourseFactory implements CourseFactory {

    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}
