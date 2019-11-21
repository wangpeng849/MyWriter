package com.wangp.myaop.xuyu;

import java.util.*;
import java.util.stream.Collectors;

public class Map2Java {

    public static Map map2Java(){

        Map<String,Integer> map = new HashMap();
        map.put("1002",100);
        map.put("1003",200);
        map.put("1004",300);

        Collection<Integer> values = map.values();
        long sum = values.stream().collect(Collectors.summarizingInt(e -> e)).getSum();
        Map<String,FaultRate> resultmap = new HashMap<>();
        List<String> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < map.size(); i++) {
            long curValue = values.stream().limit(i + 1).collect(Collectors.summarizingInt(e -> e)).getSum();
            String rate = (float)curValue/sum*100 + "%";

            String key = keys.get(i);

            FaultRate faultRate = new FaultRate();
            faultRate.setCount(map.get(key));
            faultRate.setPercent(rate);

            resultmap.put(key,faultRate);
        }

//        map.entrySet().stream().collect(Collectors.toMap(
//                stringListEntry -> stringListEntry.getKey(),
//                stringListEntry -> new FaultRate(stringListEntry.getValue())
//        ));

//        IntSummaryStatistics collect = set.stream().collect(Collectors.summarizingInt(value -> value));
//        int total = (int) collect.getSum();

//        System.out.println(set);
        return resultmap;
    }
}
