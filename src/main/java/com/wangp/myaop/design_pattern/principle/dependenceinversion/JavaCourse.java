package com.wangp.myaop.design_pattern.principle.dependenceinversion;

/**
 * <pre>
 * classname JavaCourse
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/9 18:12
 **/
public class JavaCourse implements ICourse {

    @Override
    public void studyCourse() {
        System.out.println("学习Java课程");
    }
}
