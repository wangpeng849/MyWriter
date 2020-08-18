package com.wangp.myaop.design_pattern.structural.facade;

/**
 * <pre>
 * classname PointsPaymentService
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/17 20:38
 **/
public class PointsPaymentService {

    public boolean pay(PointsGift pointsGift) {
        //扣减积分
        System.out.println("支付" + pointsGift.getName() + "积分成功");
        return true;
    }
}
