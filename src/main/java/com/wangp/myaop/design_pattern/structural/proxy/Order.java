package com.wangp.myaop.design_pattern.structural.proxy;

/**
 * <pre>
 * classname Order
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/24 22:40
 **/
public class Order {

    private Object orderInfo;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }
}
