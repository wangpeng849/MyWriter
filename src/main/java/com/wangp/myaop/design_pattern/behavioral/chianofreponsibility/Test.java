package com.wangp.myaop.design_pattern.behavioral.chianofreponsibility;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 12:43
 **/
public class Test {

    public static void main(String[] args) {
        Approver articleApprover = new ArticleApprover();
        Approver videoApprover = new VideoApprover();
        Course course = new Course();
        course.setName("Java设计模式");
        course.setArticle("Java手记");
        course.setVideo("Java视频");

        articleApprover.setNextApprover(videoApprover);
        articleApprover.deploy(course);

    }
}
