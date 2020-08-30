package com.wangp.myaop.design_pattern.behavioral.state;

/**
 * <pre>
 * classname CourseVideoState
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 13:19
 **/
public abstract class CourseVideoState {

    protected CourseVideoContext courseVideoContext;
    
    public void setCourseVideoContext(CourseVideoContext courseVideoContext) {
        this.courseVideoContext = courseVideoContext;
    }

    public abstract void play();

    public abstract void speed();

    public abstract void pause();

    public abstract void stop();
}
