package com.wangp.myaop.design_pattern.principle.dependenceinversion;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/9 18:10
 **/
public class Test {

    public static void main(String[] args) {
        Farling farling = new Farling();
        farling.studyLikeCourse(new JavaCourse());
    }
}
