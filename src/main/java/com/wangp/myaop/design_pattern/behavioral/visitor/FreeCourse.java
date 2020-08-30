package com.wangp.myaop.design_pattern.behavioral.visitor;

/**
 * <pre>
 * classname FreeCourse
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 13:00
 **/
public class FreeCourse extends Course {

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
