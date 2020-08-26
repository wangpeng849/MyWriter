package com.wangp.myaop.design_pattern.behavioral.strategy;

/**
 * <pre>
 * classname Tesg
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 23:08
 **/
public class Test {

    public static void main(String[] args) {
//        PromotionActivity activity618 = new PromotionActivity(new FanxianPromotionStrategy());
//        PromotionActivity activity1111 = new PromotionActivity(new LijianPromotionStrategy());
//
//        activity618.executePromotion();
//        activity1111.executePromotion();

//        PromotionActivity promotionActivity = null;
//        String promotionKey = "Lijian";
//        if (StringUtils.equals(promotionKey, "Lijian")) {
//            promotionActivity = new PromotionActivity(new LijianPromotionStrategy());
//        }
//        //..

        String promotionKey = "Manjian";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getStrategy(promotionKey));
        promotionActivity.executePromotion();
    }
}
