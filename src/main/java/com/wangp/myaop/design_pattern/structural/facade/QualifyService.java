package com.wangp.myaop.design_pattern.structural.facade;

/**
 * <pre>
 * classname QualifyService
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/17 20:35
 **/
public class QualifyService {

    public boolean isAvailable(PointsGift pointsGift) {
        System.out.println("校验：" + pointsGift.getName() + " 积分资格通过 库存资格通过");
        return true;
    }
}
