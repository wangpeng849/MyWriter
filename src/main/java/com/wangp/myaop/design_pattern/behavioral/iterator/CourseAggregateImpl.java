package com.wangp.myaop.design_pattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * classname CourseAggregateImpl
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 22:37
 **/
public class CourseAggregateImpl implements CourseAggregate {

    private List courseList;

    public CourseAggregateImpl() {
        this.courseList = new ArrayList();
    }

    @Override
    public void addCourse(Course course) {
        courseList.add(course);
    }

    @Override
    public void removeCourse(Course course) {
        courseList.remove(course);
    }

    @Override
    public CourseIterator getCourseIterator() {

        return new CourseIteratorImpl(courseList);
    }
}
