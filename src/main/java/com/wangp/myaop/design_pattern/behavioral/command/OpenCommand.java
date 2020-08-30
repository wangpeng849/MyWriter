package com.wangp.myaop.design_pattern.behavioral.command;

/**
 * <pre>
 * classname OpenCommand
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 11:09
 **/
public class OpenCommand implements Command{

    private CourseVideo courseVideo;

    public OpenCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute() {
        courseVideo.open();
    }
}
