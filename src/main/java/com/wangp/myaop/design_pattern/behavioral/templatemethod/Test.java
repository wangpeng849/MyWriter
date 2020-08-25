package com.wangp.myaop.design_pattern.behavioral.templatemethod;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/25 22:14
 **/
public class Test {

    public static void main(String[] args) {
        System.out.println("Java设计模式课程 ---start");
        ACourse javaCourse = new DesignPatternCourse();
        javaCourse.makeCourse();
        System.out.println("Java设计模式课程 ---end");

        System.out.println("python设计模式课程 ---start");
        ACourse pythonCourse = new PythonCourse();
        pythonCourse.makeCourse();
        System.out.println("python设计模式课程 ---end");
    }
}
