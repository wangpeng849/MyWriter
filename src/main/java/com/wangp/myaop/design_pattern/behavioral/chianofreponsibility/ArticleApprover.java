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
public class ArticleApprover extends Approver {

    @Override
    public void deploy(Course course) {
        if (course.getArticle() != null) {
            System.out.println(course.getName() + "含有手记，批准");
            if (approver != null) {
                approver.deploy(course);
            }
        } else {
            System.out.println(course.getName() + "不含有手记，驳回");
        }
    }
}
