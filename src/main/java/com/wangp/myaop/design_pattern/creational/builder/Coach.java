package com.wangp.myaop.design_pattern.creational.builder;

/**
 * <pre>
 * classname Coach
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/15 9:42
 **/
public class Coach {

    private CourseBuilder courseBuilder;

    public void setCourseBuilder(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }

    public Course makeCourse(String courseName, String coursePPT, String courseArticle, String courseVideo,
            String courseQA) {
        courseBuilder.buildCourseName(courseName);
        courseBuilder.buildCoursePPT(coursePPT);
        courseBuilder.buildCourseArticle(courseArticle);
        courseBuilder.buildCourseVideo(courseVideo);
        courseBuilder.buildCourseQA(courseQA);
        return courseBuilder.makeCourse();
    }
}
