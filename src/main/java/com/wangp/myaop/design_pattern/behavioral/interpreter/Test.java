package com.wangp.myaop.design_pattern.behavioral.interpreter;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/27 22:48
 **/
public class Test {

    public static void main(String[] args) {
        String wangpInputStr = "6 100 11 + *";
        WangpExpressionParser expressionParser = new WangpExpressionParser();
        int result = expressionParser.parse(wangpInputStr);
        System.out.println("解释器计算结果：" + result);
    }
}
