package com.wangp.myaop.designpattern;


import lombok.Data;

/**
 *  1. StringBuffered 就运用了建造者模式
 *
 *
 *  2、使用场景：
 * 多个部件或者零件，都可以装配到一个对象中，但是产生的运行结果又相同。
 * 产品类非常复杂，或者产品类中调用顺序不同产生了不同的作用。
 * 初始化一个对象特别复杂，如使用多个构造方法，或者说有很多参数，并且都有默认值时。
 *
 *
 *
 * 3、核心类
 * （1） 抽象产品类 computer。
 * （2） Builder 抽象 Builder，规范产品的组建，一般是由子类实现具体的组建过程。
 * （3）MacbookBuilder 具体的Builder类，具体的创建对象的类。
 * （4） Directror 统一组建过程。
 *
 *
 *
 * 例1】用建造者（Builder）模式描述客厅装修。
 *
 * 分析：客厅装修是一个复杂的过程，它包含墙体的装修、电视机的选择、沙发的购买与布局等。
 * 客户把装修要求告诉项目经理，项目经理指挥装修工人一步步装修，
 * 最后完成整个客厅的装修与布局，所以本实例用建造者模式实现比较适合。
 *
 * 这里客厅是产品，包括墙、电视和沙发等组成部分。具体装修工人是具体建造者，
 * 他们负责装修与墙、电视和沙发的布局。项目经理是指挥者，他负责指挥装修工人进行装修。
 *
 */
public class BuilderPattern {
    public static void main(String[] args) {
//        StringBuffer
        ProjectManager pm = new ProjectManager(new DecoratorA());
        pm.decorator();
        System.out.println(pm.getDecorator());
    }
}

class ParlourDecorator{

}

//客厅
@Data
class Parlour{
    private String wall;
    private String TV;
    private String sofa;
}

//装修工人
@Data
abstract class Decorator{
    Parlour parlour = new Parlour();
    public abstract void buildWall();
    public abstract void buildTV();
    public abstract void buildSofa();
    public Parlour getResult(){
        return parlour;
    }
}
//装修工人A
class DecoratorA extends Decorator{

    @Override
    public void buildWall() {
        parlour.setWall("wall A");
    }

    @Override
    public void buildTV() {
        parlour.setTV("Tv A");
    }

    @Override
    public void buildSofa() {
        parlour.setSofa("Sofa A");
    }
}

//项目经理
@Data
class ProjectManager{
    private Decorator decorator;

    public ProjectManager(Decorator decorator){
        this.decorator = decorator;
    }

    public Parlour decorator(){
        decorator.buildSofa();
        decorator.buildTV();
        decorator.buildWall();
        return decorator.getResult();
    }
}