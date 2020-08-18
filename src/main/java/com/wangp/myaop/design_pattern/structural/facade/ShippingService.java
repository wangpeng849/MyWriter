package com.wangp.myaop.design_pattern.structural.facade;

/**
 * <pre>
 * classname ShippingService
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/17 20:39
 **/
public class ShippingService {

    public String shipGift(PointsGift pointsGift) {
        //物流系统的对接
        System.out.println(pointsGift.getName() + " 进入物流系统");
        String shippingOrderNo = "666";
        return shippingOrderNo;
    }
}
