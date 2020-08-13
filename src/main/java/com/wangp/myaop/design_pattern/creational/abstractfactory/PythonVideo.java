package com.wangp.myaop.design_pattern.creational.abstractfactory;

/**
 * <pre>
 * classname PythonVideo
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/12 20:29
 **/
public class PythonVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制 python 视频");
    }
}
