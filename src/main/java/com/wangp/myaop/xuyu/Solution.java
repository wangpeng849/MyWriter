package com.wangp.myaop.xuyu;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        Map map = Map2Java.map2Java();
//        System.out.println(map);


        Map map  = new LinkedHashMap();
        map.put("b","123");
        map.put("c","46");
        map.put("a","458");
        System.out.println(map);

        Set set = new LinkedHashSet();
        set.add("111");
        set.add("222");
        set.add("11");
        set.add("333");
        set.add("343");
        set.add("313");
        set.add("383");
        set.add("443");
        set.add("213");
        for (Object o : set) {
            System.out.println(o);
        }

    }
}
