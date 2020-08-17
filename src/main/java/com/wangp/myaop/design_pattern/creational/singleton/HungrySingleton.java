package com.wangp.myaop.design_pattern.creational.singleton;

import java.io.Serializable;

/**
 * <pre>
 * classname HungrySingleton
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/16 15:06
 **/
public class HungrySingleton implements Serializable {

    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
        if (hungrySingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    public Object readResolve() {
        return hungrySingleton;
    }
}
