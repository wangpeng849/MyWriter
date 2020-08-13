package com.wangp.myaop.design_pattern.creational.abstractfactory;

/**
 * <pre>
 * classname JavaVideo
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/12 20:29
 **/
public class JavaVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制 Java 视频");
    }
}
