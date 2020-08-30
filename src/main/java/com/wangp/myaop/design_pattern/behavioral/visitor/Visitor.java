package com.wangp.myaop.design_pattern.behavioral.visitor;

/**
 * <pre>
 * classname Visitor
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 12:59
 **/
public class Visitor implements IVisitor {

    @Override
    public void visit(FreeCourse freeCourse) {
        System.out.println("免费课程：" + freeCourse.getName());
    }

    @Override
    public void visit(CodingCourse codingCourse) {
        System.out.println("实战课程：" + codingCourse.getName() + "-->$" + codingCourse.getPrice());
    }
}
