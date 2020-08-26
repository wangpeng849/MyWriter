package com.wangp.myaop.design_pattern.behavioral.strategy;

/**
 * <pre>
 * classname PromotionActivity
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 23:06
 **/
public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void executePromotion() {
        promotionStrategy.doPromotion();
    }
}
