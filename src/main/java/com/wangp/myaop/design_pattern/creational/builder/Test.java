package com.wangp.myaop.design_pattern.creational.builder;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/15 9:46
 **/
public class Test {

    public static void main(String[] args) {
        Coach coach = new Coach();
        CourseBuilder courseBuilder = new CourseActualBuilder();
        coach.setCourseBuilder(courseBuilder);
        Course java = coach.makeCourse("Java", "Java-PPT", "Java-Article",
                "Java-Video", "Java-QA");
        System.out.println(java);
    }
}
