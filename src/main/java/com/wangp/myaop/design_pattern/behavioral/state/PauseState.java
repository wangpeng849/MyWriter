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
public class PauseState extends CourseVideoState {

    @Override
    public void play() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PLAY_VIDEO_STATE);
    }

    @Override
    public void speed() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.SPEED_VIDEO_STATE);

    }

    @Override
    public void pause() {
        System.out.println("暂停播放的课程");
    }

    @Override
    public void stop() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.STOP_VIDEO_STATE);
    }
}
