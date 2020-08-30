package com.wangp.myaop.design_pattern.behavioral.command;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 11:11
 **/
public class Test {

    public static void main(String[] args) {
        CourseVideo courseVideo = new CourseVideo("Java设计模式");
        Command openCommand = new OpenCommand(courseVideo);
        Staff staff = new Staff();
        staff.addCommand(openCommand);
        Command closeCommand = new CloseCommand(courseVideo);
        staff.addCommand(closeCommand);

        staff.executorCommand();
    }
}
