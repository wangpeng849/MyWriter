package com.wangp.myaop.design_pattern.structural.adapter;

/**
 * <pre>
 * classname AC220
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/19 22:25
 **/
public class AC220 {

    public int output220V() {
        int output = 220;
        System.out.println("输出交流电：" + output + "V");
        return output;
    }
}
