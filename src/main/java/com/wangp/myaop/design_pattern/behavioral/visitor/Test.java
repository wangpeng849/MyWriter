package com.wangp.myaop.design_pattern.behavioral.visitor;

import java.util.ArrayList;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 13:07
 **/
public class Test {

    public static void main(String[] args) {
        ArrayList<Course> courseList = new ArrayList<>();
        FreeCourse freeCourse = new FreeCourse();
        freeCourse.setName("Spring课程");

        CodingCourse codingCourse = new CodingCourse();
        codingCourse.setName("Java设计模式");
        codingCourse.setPrice(19);

        courseList.add(freeCourse);
        courseList.add(codingCourse);
        for (Course course : courseList) {
            course.accept(new Visitor());
        }
    }
}
