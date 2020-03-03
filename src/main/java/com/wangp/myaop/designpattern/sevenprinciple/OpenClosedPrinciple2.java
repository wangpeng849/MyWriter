package com.wangp.myaop.designpattern.sevenprinciple;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 9:04
 *
 *  开闭原则
 *  对扩展开放（对提供方），对修改关闭（对使用方）
 *  用抽象构建框架，用实现扩展细节
 *
 *
 *  遵循其他原则，使用设计模式的目的就是遵循开闭原则
 */
public class OpenClosedPrinciple2 {
    public static void main(String[] args) {
        GraphicEditor2 graphicEditor = new GraphicEditor2();
        graphicEditor.drawShape(new Rectangle2());
        graphicEditor.drawShape(new Circle2());
        graphicEditor.drawShape(new Triangle());
        //绘制矩形
        //绘制圆形
        //绘制三角形
    }
}

//用于绘图的类
class GraphicEditor2{
    //接受Shape对象，根据type绘制不同的形状
    public void drawShape(NewShape s){
      s.draw();
    }
}

abstract class NewShape{
    int m_type;
    public abstract void draw();
}

class Rectangle2 extends NewShape{
    Rectangle2(){
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

class Circle2 extends NewShape{
    Circle2(){
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

class Triangle extends NewShape{
    Triangle(){
        super.m_type = 3;
    }

    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }
}