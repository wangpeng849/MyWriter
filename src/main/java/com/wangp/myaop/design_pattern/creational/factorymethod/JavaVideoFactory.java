package com.wangp.myaop.design_pattern.creational.factorymethod;

/**
 * <pre>
 * classname JavaVideoFactory
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/12 20:06
 **/
public class JavaVideoFactory extends VideoFactory {

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
