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
public class OpenClosedPrinciple1 {
    public static void main(String[] args) {
        //使用看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        //绘制矩形
        //绘制圆形
        //新加一个三角形？需要修改大量代码
    }
}

//用于绘图的类
class GraphicEditor{
    //接受Shape对象，根据type绘制不同的形状
    public void drawShape(Shape s){
        if(s.m_type == 1){
            drawRectangle(s);
        }else if(s.m_type == 2){
            drawCircle(s);
        }
    }

    private void drawCircle(Shape s) {
        System.out.println("绘制圆形");
    }

    private void drawRectangle(Shape s) {
        System.out.println("绘制矩形");
    }
}

class Shape{
    int m_type;
}
class Rectangle extends Shape{
    Rectangle(){
        super.m_type = 1;
    }
}
class Circle extends Shape{
    Circle(){
        super.m_type = 2;
    }
}