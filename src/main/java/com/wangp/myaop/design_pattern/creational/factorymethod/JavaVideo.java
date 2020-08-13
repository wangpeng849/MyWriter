package com.wangp.myaop.design_pattern.creational.factorymethod;

/**
 * <pre>
 * classname JavaVideo
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/12 19:39
 **/
public class JavaVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制 java 的视频");
    }
}
