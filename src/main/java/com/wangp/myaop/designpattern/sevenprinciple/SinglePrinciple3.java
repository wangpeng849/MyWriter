package com.wangp.myaop.designpattern.sevenprinciple;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/2 8:55
 *
 * 单一职责原则
 */
public class SinglePrinciple3 {
    public static void main(String[] args) {
        Vehicle2 vehicle = new Vehicle2();
        vehicle.run("摩托车");
        vehicle.runAir("飞机");
        vehicle.runWater("轮船");
        //摩托车在公路上运行....
        //飞机在天空上运行....
        //轮船在水上运行....

        //没有对原来类做大修改
        //虽然没有在类级别遵守单一职责，但是在方法级别上遵守单一职责
    }
}

//交通工具类（改进版）
class Vehicle2{
    public void run(String vehicle){
        System.out.println(vehicle + "在公路上运行....");
    }
    public void runAir(String vehicle){
        System.out.println(vehicle + "在天空上运行....");
    }
    public void runWater(String vehicle){
        System.out.println(vehicle + "在水上运行....");
    }
}
