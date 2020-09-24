package com.wangp.myaop.jdk11.string;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * classname StringTest
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/9/21 20:26
 **/
public class StringTest {

    public static void main(String[] args) {
        String str = "    hello JDK 11       ";
        System.out.println("去前后空格：" + str.trim());
        System.out.println("去前后空格：" + str.strip());
        System.out.println("去前空格：" + str.stripLeading());
        System.out.println("去后空格：" + str.stripTrailing());
        System.out.println("是否为空白：" + "   ".isBlank());
        System.out.println("是否为空白：" + "   ".isEmpty());

        String strList = "one\ntwo\nthree";
        List<String> list = strList.lines().collect(Collectors.toList());
        System.out.println(list);

        System.out.println("repeat".repeat(3));

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.compareTo(new StringBuilder("1")));
    }
}
