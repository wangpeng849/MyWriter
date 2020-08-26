package com.wangp.myaop.design_pattern.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * classname PromotionStrategyFactory
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 23:12
 **/
public class PromotionStrategyFactory {

    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.LIJIAN, new LijianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.Manjian, new ManjianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.Fanxian, new FanxianPromotionStrategy());
    }

    private PromotionStrategyFactory() {
    }

    public static PromotionStrategy getStrategy(String promotionKey) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy;
    }

    private interface PromotionKey {

        String LIJIAN = "Lijian";
        String Manjian = "Manjian";
        String Fanxian = "Fanxian";
    }
}
