package com.wangp.myaop.design_pattern.behavioral.visitor;

/**
 * <pre>
 * classname IVisitor
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 12:58
 **/
public interface IVisitor {

    void visit(FreeCourse freeCourse);

    void visit(CodingCourse codingCourse);
}
