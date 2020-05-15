package com.wangp.myaop.util;

import static com.github.nobodxbodon.zhconverter.简繁转换类.取实例;
import static com.github.nobodxbodon.zhconverter.简繁转换类.目标;

/**
 * @Author wangp
 * @Date 2020/5/15
 * @Version 1.0
 */
public class FontTransUtils {

    public static void main(String[] args) {
        String s = simple2Complex("测试数据1");
        System.out.println(s);
    }


    public static String simple2Complex(String text){
        return 取实例(目标.繁体).转换(text);
    }
}
