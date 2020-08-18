package com.wangp.myaop.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * classname GiveValueTest
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/18 20:15
 **/
public class GiveValueTest {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        Map<String, String> map = Maps.newHashMap();
        String str = "test";
        processList(list, map, str);

        System.out.println(list);
        System.out.println(map);
        System.out.println(str);
    }

    public static void processList(List<String> list, Map<String, String> map, String str) {
//        list = Arrays.asList("aaa", "bbb", "ccc");  --> not value
        list.add("eee");
        map.put("aaa", "ccc");
    }
}
