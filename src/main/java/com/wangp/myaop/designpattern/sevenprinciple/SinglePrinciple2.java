package com.wangp.myaop.designpattern.sevenprinciple;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/2 8:55
 *
 * 单一职责原则
 */
public class SinglePrinciple2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("摩托车");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("轮船");
        //摩托车在公路上运行....
        //飞机在天空上运行....
        //轮船在水上运行....

        //遵守单一职责  但是难以维护

    }
}

//交通工具类
class RoadVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在公路上运行....");
    }
}
class AirVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在天空上运行....");
    }
}
class WaterVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在水上运行....");
    }
}
