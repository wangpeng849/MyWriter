package com.wangp.myaop.design_pattern.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * <pre>
 * classname Teacher
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/28 22:11
 **/
public class Teacher implements Observer {

    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public void update(Observable o, Object arg) {
        Course course = (Course) o;
        Question question = (Question) arg;
        System.out.println(
                this.getTeacherName() +
                        "老师的" + course.getCourseName() +
                        "收到了" + question.getUserName() +
                        "提交的问题：" + question.getContent());
    }
}
