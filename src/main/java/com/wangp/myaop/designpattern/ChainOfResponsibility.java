package com.wangp.myaop.designpattern;

/**
 * @Author wangp
 * @Date 2020/7/7
 * @Version 1.0
 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        Handler handler3 = new ConcreteHandler2();
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);
        //提交请求
        handler1.handleRequest();
    }
}

abstract class Handler{
    /**
     * 后继对象
     */
    protected Handler successor;
    /**
     * 示意请求方法
     */
    public abstract void handleRequest();
    /**
     * 取值方法
     */
    public Handler getSuccessor(){
        return successor;
    }
    /**
     * 赋值方法
     * @param successor
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}

class ConcreteHandler extends Handler{

    @Override
    public void handleRequest() {
        if(getSuccessor()!=null){
            getSuccessor().handleRequest();
        }
        System.out.println("具体实现1");
    }
}

class ConcreteHandler2 extends Handler{

    @Override
    public void handleRequest() {
        System.out.println("具体实现2");
    }
}