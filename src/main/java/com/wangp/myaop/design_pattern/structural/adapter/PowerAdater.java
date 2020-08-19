package com.wangp.myaop.design_pattern.structural.adapter;

/**
 * <pre>
 * classname PowerAdater
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/19 22:33
 **/
public class PowerAdater implements DC5 {

    AC220 ac220 = new AC220();

    @Override
    public int output5V() {
        int adaterInput = ac220.output220V();
        //变压器
        int adapteOutput = adaterInput / 44;
        System.out.println("使用powerAdapter将" + adaterInput + "转换为" + adapteOutput);
        return adapteOutput;
    }
}
