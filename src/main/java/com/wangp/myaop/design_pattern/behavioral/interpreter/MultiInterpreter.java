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
public class MultiInterpreter implements Interpreter {

    private Interpreter firstExpress, secondExpress;

    public MultiInterpreter(Interpreter firstExpress, Interpreter secondExpress) {
        this.firstExpress = firstExpress;
        this.secondExpress = secondExpress;
    }

    @Override
    public int interpret() {
        return firstExpress.interpret() * secondExpress.interpret();
    }

    @Override
    public String toString() {
        return "*";
    }
}
