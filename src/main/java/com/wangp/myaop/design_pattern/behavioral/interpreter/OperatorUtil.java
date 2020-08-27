package com.wangp.myaop.design_pattern.behavioral.interpreter;

/**
 * <pre>
 * classname OperatorUtil
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/27 23:02
 **/
public class OperatorUtil {

    public static boolean isOperator(String symbol) {
        return "+".equals(symbol) || "*".equals(symbol);
    }

    public static Interpreter getExpressObject(Interpreter firstExpress, Interpreter secondExpress, String symbol) {
        if ("+".equals(symbol)) {
            return new AddInterpreter(firstExpress, secondExpress);
        } else {
            return new MultiInterpreter(firstExpress, secondExpress);
        }
    }
}
