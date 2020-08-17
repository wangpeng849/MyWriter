package com.wangp.myaop.design_pattern.creational.builder;

/**
 * <pre>
 * classname CourseBuilder
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/15 9:36
 **/
public abstract class CourseBuilder {

    public abstract void buildCourseName(String courseName);

    public abstract void buildCoursePPT(String coursePPT);

    public abstract void buildCourseVideo(String courseVideo);

    public abstract void buildCourseArticle(String courseArticle);

    public abstract void buildCourseQA(String courseQA);

    public abstract Course makeCourse();
}
