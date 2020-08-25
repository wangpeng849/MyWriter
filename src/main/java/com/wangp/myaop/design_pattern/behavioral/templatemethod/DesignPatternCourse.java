package com.wangp.myaop.design_pattern.behavioral.templatemethod;

/**
 * <pre>
 * classname DesignPatternCourse
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/25 22:13
 **/
public class DesignPatternCourse extends ACourse {

    @Override
    void packageCourse() {
        System.out.println("提供java源代码");
    }

    @Override
    protected boolean needWriteArticle() {
        return true;
    }
}
