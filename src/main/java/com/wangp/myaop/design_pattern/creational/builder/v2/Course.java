package com.wangp.myaop.design_pattern.creational.builder.v2;

import lombok.Data;

/**
 * <pre>
 * classname Course
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/15 9:35
 **/
@Data
public class Course {

    private String courseName;
    private String coursePPT;
    private String courseVideo;
    private String courseQA;
    private String courseArticle;

    public Course(CourseBuilder courseBuilder) {
        this.courseName = courseBuilder.courseName;
        this.coursePPT = courseBuilder.coursePPT;
        this.courseVideo = courseBuilder.courseVideo;
        this.courseArticle = courseBuilder.courseArticle;
        this.courseQA = courseBuilder.courseQA;
    }

    public static class CourseBuilder {

        private String courseName;
        private String coursePPT;
        private String courseVideo;
        private String courseQA;
        private String courseArticle;


        public static CourseBuilder builder() {
            return new CourseBuilder();
        }

        public CourseBuilder buildCourseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public CourseBuilder buildCoursePPT(String coursePPT) {
            this.coursePPT = coursePPT;
            return this;
        }

        public CourseBuilder buildCourseVideo(String courseVideo) {
            this.courseVideo = courseVideo;
            return this;
        }

        public CourseBuilder buildCourseArticle(String courseArticle) {
            this.courseArticle = courseArticle;
            return this;
        }

        public CourseBuilder buildCourseQA(String courseQA) {
            this.courseQA = courseQA;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}
