package com.wangp.myaop.design_pattern.principle.openclose;

/**
 * <pre>
 * classname JavaDiscountCourse
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/9 15:16
 **/
public class JavaDiscountCourse extends JavaCourse {

    public JavaDiscountCourse(Integer id, String name, double price) {
        super(id, name, price);
    }

    public Double getOriginPrice() {
        return super.getPrice();
    }

    @Override
    public Double getPrice() {
        return super.getPrice() * 0.8;
    }
}
