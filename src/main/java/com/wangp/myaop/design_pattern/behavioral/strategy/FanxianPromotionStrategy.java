package com.wangp.myaop.design_pattern.behavioral.strategy;

/**
 * <pre>
 * classname FanxianPromotionStrategy
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 23:06
 **/
public class FanxianPromotionStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("返现促销，购买后，返到用户余额中");
    }
}
