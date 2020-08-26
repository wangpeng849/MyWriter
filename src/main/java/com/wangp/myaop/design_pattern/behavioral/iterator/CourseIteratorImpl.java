package com.wangp.myaop.design_pattern.behavioral.iterator;

import java.util.List;

/**
 * <pre>
 * classname CourseIteratorImpl
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 22:43
 **/
public class CourseIteratorImpl implements CourseIterator {

    private List courseList;
    private int position;

    private Course course;

    public CourseIteratorImpl(List courseList) {
        this.courseList = courseList;
    }

    @Override
    public Course nextCourse() {
        System.out.println("课程的位置是:" + position);
        Course course = (Course) courseList.get(position);
        position++;
        return course;
    }

    @Override
    public boolean isLastCourse() {
        if (position < courseList.size()) {
            return false;
        }
        return true;
    }
}
