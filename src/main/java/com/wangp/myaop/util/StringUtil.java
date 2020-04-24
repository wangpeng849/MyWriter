package com.wangp.myaop.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * programName: fitaipolicy
 * fileName: StringUtil
 * author: ltl
 * createTime:2020/3/20 16:51
 */
public class StringUtil {
    /**
     * 将枚举类内容转化为list
     *
     * @param es
     * @return
     */
    public static List<String> splitEnum(String es) {
        return Lists.newArrayList(Splitter.on(',').trimResults().split(es));
    }
}
