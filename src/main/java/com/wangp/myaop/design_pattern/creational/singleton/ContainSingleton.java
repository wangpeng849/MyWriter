package com.wangp.myaop.design_pattern.creational.singleton;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 * classname ContainSingleton
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/17 17:48
 **/
public class ContainSingleton {

    private static Map<String, Object> singletonMap = new HashMap();

    public static void putInstance(String key, Object instance) {
        if (StringUtils.isNotBlank(key) && instance != null) {
            if (!singletonMap.containsKey(key)) {
                singletonMap.put(key, instance);
            }
        }
    }

    public static Object getInstance(String key) {
        return singletonMap.get(key);
    }

    private ContainSingleton() {
    }
}
