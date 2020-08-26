package com.wangp.myaop.design_pattern.behavioral.iterator;

/**
 * <pre>
 * classname CourseAggregate
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 22:35
 **/
public interface CourseAggregate {

    void addCourse(Course course);

    void removeCourse(Course course);

    CourseIterator getCourseIterator();
}
