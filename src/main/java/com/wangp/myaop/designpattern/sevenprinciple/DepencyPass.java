package com.wangp.myaop.designpattern.sevenprinciple;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/2 10:01
 *
 * 依赖传递方式
 */
public class DepencyPass {

    public static void main(String[] args) {
    }
}

//方式一  通过接口传递依赖
//开关的接口
//interface IOpenAndClose{
//    public void open(ITV tv);
//}
//interface ITV{
//    public void play();
//}
////实现接口
//class OpenAndClose implements IOpenAndClose{
//
//    @Override
//    public void open(ITV tv) {
//        tv.play();
//    }
//}

//方式二  通过构造函数传递
interface IOpenAndClose{
    public void open();
}
interface ITV{
    public void play();
}
class OpenAndClose implements IOpenAndClose{

    public ITV itv;

    public OpenAndClose(ITV itv) {
        this.itv = itv;
    }

    @Override
    public void open() {
        this.itv.play();
    }
}

//方式三  set传递