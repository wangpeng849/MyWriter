package com.wangp.myaop.design_pattern.creational.factorymethod;

/**
 * <pre>
 * classname PythonFactory
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/12 20:06
 **/
public class PythonFactory extends VideoFactory {

    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
