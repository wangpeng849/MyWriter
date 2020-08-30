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
public class PlayState extends CourseVideoState {

    @Override
    public void play() {
        System.out.println("正在播放的课程");
    }

    @Override
    public void speed() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.SPEED_VIDEO_STATE);
    }

    @Override
    public void pause() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PAUSE_VIDEO_STATE);
    }

    @Override
    public void stop() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.STOP_VIDEO_STATE);
    }
}
