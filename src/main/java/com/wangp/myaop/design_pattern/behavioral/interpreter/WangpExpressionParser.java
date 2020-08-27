package com.wangp.myaop.design_pattern.behavioral.interpreter;


import java.util.Stack;

/**
 * <pre>
 * classname WangpExpressionParser
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/27 22:49
 **/
public class WangpExpressionParser {

    private Stack<Interpreter> stack = new Stack();

    public int parse(String str) {
        String[] strItemArray = str.split(" ");
        for (String symbol : strItemArray) {
            if (!OperatorUtil.isOperator(symbol)) {
                Interpreter numberExpress = new NumberInterpreter(symbol);
                stack.push(numberExpress);
                System.out.println("入栈：" + numberExpress.interpret());
            } else {
                Interpreter firstExpress = stack.pop();
                Interpreter secondExpress = stack.pop();
                System.out.println("出栈：" + firstExpress.interpret());
                System.out.println("出栈：" + secondExpress.interpret());
                Interpreter expressObject = OperatorUtil.getExpressObject(firstExpress, secondExpress, symbol);
                System.out.println("计算结果入栈：" + expressObject.interpret());
                stack.push(expressObject);
            }
        }
        int res = stack.pop().interpret();
        return res;
    }
}
