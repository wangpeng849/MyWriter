package com.wangp.myaop.designpattern.create.gongchang.simplefactory;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 15:42
 */
public abstract class Pizza {
    protected String name;
    //准备原材料  不同的披萨材料不同
    public abstract void prepare();
    public void bake(){
        System.out.println(name + "  baking;");
    }
    public void cut(){
        System.out.println(name + "  cuting;");
    }
    public void box(){
        System.out.println(name + "  boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }
}
