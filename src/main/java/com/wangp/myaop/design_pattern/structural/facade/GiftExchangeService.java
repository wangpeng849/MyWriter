package com.wangp.myaop.design_pattern.structural.facade;

/**
 * <pre>
 * classname GiftExchangeService
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/17 20:41
 **/
public class GiftExchangeService {

    private QualifyService qualifyService = new QualifyService();
    private PointsPaymentService pointsPaymentService = new PointsPaymentService();
    private ShippingService shippingService = new ShippingService();

    public void setQualifyService(QualifyService qualifyService) {
        this.qualifyService = qualifyService;
    }

    public void setPointsPaymentService(
            PointsPaymentService pointsPaymentService) {
        this.pointsPaymentService = pointsPaymentService;
    }

    public void setShippingService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void giftExchange(PointsGift pointsGift) {
        if (qualifyService.isAvailable(pointsGift)) {
            //资格通过
            if (pointsPaymentService.pay(pointsGift)) {
                //积分支付通过
                System.out.println(shippingService.shipGift(pointsGift));
            }
        }
    }
}
