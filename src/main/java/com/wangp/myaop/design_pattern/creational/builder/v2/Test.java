package com.wangp.myaop.design_pattern.creational.builder.v2;

import com.wangp.myaop.design_pattern.creational.builder.v2.Course.CourseBuilder;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/15 9:56
 **/
public class Test {

    public static void main(String[] args) {
        Course course = new Course.CourseBuilder().buildCourseName("Java").buildCoursePPT("Java-PPT")
                .buildCourseArticle("Java-Artcle").buildCourseVideo("Java-Video").buildCourseQA("Java-QA").build();
        System.out.println(course);
        
        Course java = CourseBuilder.builder().buildCourseName("Java").buildCoursePPT("Java-PPT")
                .buildCourseArticle("Java-Artcle").buildCourseVideo("Java-Video").buildCourseQA("Java-QA").build();
        System.out.println(java);
    }
}
