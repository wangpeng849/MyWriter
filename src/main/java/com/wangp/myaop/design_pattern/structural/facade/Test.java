package com.wangp.myaop.design_pattern.structural.facade;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/17 20:44
 **/
public class Test {

    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("鼠标");
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        giftExchangeService.giftExchange(pointsGift);
    }
}
