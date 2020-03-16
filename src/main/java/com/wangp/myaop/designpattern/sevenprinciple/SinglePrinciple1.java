package com.wangp.myaop.designpattern.sevenprinciple;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/2 8:55
 *
 * 单一职责原则
 * 单一职责原则注意事项和细节
 *      1)降低类的复杂度,一个类只负责一项职责
 *      2)提高卖的可读性,可维护性
 *      3)降低变更引起的风险
 *      4)通常情况下,我们应当遵守单一职责原则,只有逻辑足够简单,才可以在代码级违反单一职责原则:
 *      只有类中方法数量足够少,可以在方法级别保持单一职责原则
 */
public class SinglePrinciple1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("自行车");
        vehicle.run("摩托车");
        vehicle.run("飞机");
        //自行车在公路上运行....
        //摩托车在公路上运行....
        //飞机在公路上运行....

        //飞机显然不能在公路上  违背单一职责
    }
}

//交通工具类
class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在公路上运行....");
    }
}
