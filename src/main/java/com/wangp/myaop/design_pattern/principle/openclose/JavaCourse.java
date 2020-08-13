package com.wangp.myaop.design_pattern.principle.openclose;

import lombok.Data;

/**
 * <pre>
 * classname JavaCourse
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/9 15:11
 **/
@Data
public class JavaCourse implements ICourse {

    private Integer id;
    private String name;
    private double price;

    public JavaCourse(Integer id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
