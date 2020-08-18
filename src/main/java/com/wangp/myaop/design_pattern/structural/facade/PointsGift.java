package com.wangp.myaop.design_pattern.structural.facade;

import lombok.Data;

/**
 * <pre>
 * classname PointsGift
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/17 20:35
 **/
@Data
public class PointsGift {

    private String name;

    public PointsGift(String name) {
        this.name = name;
    }
}
