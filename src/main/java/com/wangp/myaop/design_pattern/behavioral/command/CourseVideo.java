package com.wangp.myaop.design_pattern.behavioral.command;

/**
 * <pre>
 * classname CourseVideo
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 10:49
 **/
public class CourseVideo {

    private String name;

    public CourseVideo(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println(name + "课程开放了");
    }

    public void close() {
        System.out.println(name + "课程关闭了");
    }

}
