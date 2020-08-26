package com.wangp.myaop.design_pattern.behavioral.iterator;

/**
 * <pre>
 * classname CourseIterator
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 22:36
 **/
public interface CourseIterator {

    Course nextCourse();

    boolean isLastCourse();
}
