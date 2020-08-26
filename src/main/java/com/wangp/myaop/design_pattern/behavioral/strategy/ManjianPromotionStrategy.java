package com.wangp.myaop.design_pattern.behavioral.strategy;

/**
 * <pre>
 * classname ManjianPromotionStrategy
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 23:04
 **/
public class ManjianPromotionStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("满减促销，满200减20");
    }
}
