package com.wangp.myaop.design_pattern.structural.composite;

/**
 * <pre>
 * classname Course
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/23 15:49
 **/
public class Course extends CatalogComponent {

    private String name;
    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public double getPrice(CatalogComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println("Course name:" + this.name + ",Price:" + this.price);
    }
}
