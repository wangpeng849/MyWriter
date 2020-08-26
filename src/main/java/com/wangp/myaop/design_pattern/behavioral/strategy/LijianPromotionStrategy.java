package com.wangp.myaop.design_pattern.behavioral.strategy;

/**
 * <pre>
 * classname LijianPromotionStrategy
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 23:04
 **/
public class LijianPromotionStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("立减促销，课程价格立减配置的价格");
    }
}
