package com.wangp.myaop.design_pattern.principle.dependenceinversion;

/**
 * <pre>
 * classname Farling
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/9 18:09
 **/
public class Farling {

    public void studyLikeCourse(ICourse course) {
        course.studyCourse();
    }
}
