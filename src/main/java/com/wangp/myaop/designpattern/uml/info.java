package com.wangp.myaop.designpattern.uml;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 14:31
 */
public class info {
    /**
     * 1.依赖关系：
     * 	1）只要在类中用到就存在依赖关系
     * 	2）类的成员变量
     * 	3）方法的返回值
     * 	4）方法的传参
     * 	5）方法的局部变量
     * 2.泛化关系
     * 	1）泛化关系实际上就是继承关系
     * 	2）A类继承了B类，就说A和B存在泛化关系
     * 3.实现关系
     * 	1）实际上就是A类实现了B接口
     * 4.关联关系
     * 	关联关系实际上就是类与类之间的联系
     * 	具有导航型（双向关系或单向关系）和多重性（1对1，多对多....）
     * 5.聚合关系
     * 	表示整体和部分的关系，是关联关系的特例，组件是可以分离的表示是聚合关系，如电脑的鼠
     * 标，是可以和电脑分离的，用空心菱形表示。
     * 	代码为：
     * 	public class Computer{
     * 		private Mouse mouse;
     * 		//getter/setter
     *        }
     * 6.组合关系
     * 	整体和部分不可分离
     * 	代码为：
     * 	public class Computer{
     * 		private Mouse mouse = new Mouse();
     *    }
     */
}
