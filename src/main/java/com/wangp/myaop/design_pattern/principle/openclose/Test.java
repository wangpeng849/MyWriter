package com.wangp.myaop.design_pattern.principle.openclose;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/9 15:12
 **/
public class Test {

    public static void main(String[] args) {
        ICourse course = new JavaCourse(1, "Java", 20);
        System.out.println(course);
        ICourse disCountCourse = new JavaDiscountCourse(1, "Java", 20);
        System.out.println(disCountCourse);
        System.out.println(((JavaDiscountCourse) disCountCourse).getOriginPrice());
    }
}
