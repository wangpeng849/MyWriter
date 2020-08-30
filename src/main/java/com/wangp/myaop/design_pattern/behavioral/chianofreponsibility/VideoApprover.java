package com.wangp.myaop.design_pattern.behavioral.chianofreponsibility;

/**
 * <pre>
 * classname ArticleApprover
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 12:40
 **/
public class VideoApprover extends Approver {

    @Override
    public void deploy(Course course) {
        if (course.getVideo() != null) {
            System.out.println(course.getName() + "含有视频，批准");
            if (approver != null) {
                approver.deploy(course);
            }
        } else {
            System.out.println("不含有视频，驳回");
        }
    }
}
