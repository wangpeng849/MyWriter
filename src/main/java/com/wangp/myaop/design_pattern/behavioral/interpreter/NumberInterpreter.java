package com.wangp.myaop.design_pattern.behavioral.interpreter;

/**
 * <pre>
 * classname AddInterpreter
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/27 22:52
 **/
public class NumberInterpreter implements Interpreter {

    private int number;

    public NumberInterpreter(int number) {
        this.number = number;
    }

    public NumberInterpreter(String number) {
        this.number = Integer.parseInt(number);
    }

    @Override
    public int interpret() {
        return this.number;
    }
}
