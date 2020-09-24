package com.wangp.myaop.jdk11.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * classname CollectionTest
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/9/21 20:19
 **/
public class CollectionTest {

    public static void main(String[] args) {
        toArray();
        unChangeCollection();
    }

    private static void toArray() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        String[] array = list.toArray(String[]::new);
        System.out.println(Arrays.toString(array));
    }

    private static void unChangeCollection() {
        List<String> list = List.of("a", "b", "c");
        List<String> copyList = List.copyOf(list);
        Set<String> set = Set.of("a", "b", "c");
        Set<String> copySet = Set.copyOf(set);
        System.out.println(list == copyList);
        System.out.println(set == copySet);
        try {
            list.add("d");
        } catch (Exception e) {
            System.out.println(list);
            System.out.println("不可变list不能添加元素！");
        }
        Map map = Map.of("key1", 1, 2, "key2");
        Map copyMap = Map.copyOf(map);
        System.out.println(map == copyMap);
        System.out.println(map);
    }
}
