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
public class SpeedState extends CourseVideoState {

    @Override
    public void play() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PLAY_VIDEO_STATE);
    }

    @Override
    public void speed() {
        System.out.println("快进播放课程");
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
