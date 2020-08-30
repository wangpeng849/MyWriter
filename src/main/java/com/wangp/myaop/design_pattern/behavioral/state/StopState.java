package com.wangp.myaop.design_pattern.behavioral.state;

/**
 * <pre>
 * classname PlayState
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 13:21
 **/
public class StopState extends CourseVideoState {

    @Override
    public void play() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PLAY_VIDEO_STATE);
    }

    @Override
    public void speed() {
        System.out.println("ERROR 停止状态不能快进");
    }

    @Override
    public void pause() {
        System.out.println("ERROR 停止状态不能暂停");
    }

    @Override
    public void stop() {
        System.out.println("课程已经停止");
    }
}
