package com.wangp.myaop.design_pattern.behavioral.observer;

import java.util.Observable;

/**
 * <pre>
 * classname Course
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/28 22:10
 **/
public class Course extends Observable {

    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void produceQuestion(Course course, Question question) {
        System.out.println(question.getUserName() + "在" + course.getCourseName() + "提交了一个问题");
        setChanged();
        notifyObservers(question);
    }

}
