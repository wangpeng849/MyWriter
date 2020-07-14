package com.wangp.myaop.designpattern.create.yuanxing.improve;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/4 18:15
 */
@Data
@AllArgsConstructor
public class Sheep implements Cloneable{
    private String name;
    private int age;
    private String color;
    private String address;

    //使用默认的克隆方法来完成克隆
    @Override
    protected Object clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
            sheep.setAddress("蒙古羊");
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}
