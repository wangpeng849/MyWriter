package com.wangp.myaop.design_pattern.behavioral.visitor;

/**
 * <pre>
 * classname CodingCourse
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 13:01
 **/
public class CodingCourse extends Course {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
