package com.wangp.myaop.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.text.MessageFormat;
import java.util.Arrays;
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
        processList(list, map);
        String str = "hello={0},world={1}";
        List<String> param = Arrays.asList("test", "other");
        String format = "";
        for (String s : param) {
            str = MessageFormat.format(str, "test", "other");
        }
        System.out.println(str);

        System.out.println(list);
        System.out.println(map);

    }

    public static void processList(List<String> list, Map<String, String> map) {
//        list = Arrays.asList("aaa", "bbb", "ccc");  --> not value
        list.add("eee");
        map.put("aaa", "ccc");
    }
}
