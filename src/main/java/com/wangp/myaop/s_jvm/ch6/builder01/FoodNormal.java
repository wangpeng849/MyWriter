package com.wangp.myaop.s_jvm.ch6.builder01;

public class FoodNormal {

    //required
    private final String foodName;
    private final int reilang;

    //optional
    private final int danbz;
    private final int dianfen;
    private final int zf;
    private final int tang;
    private  final int wss;

    public FoodNormal(String foodName,int reilang){
        this(foodName,reilang,0,0,0,0,0);
    }

    public FoodNormal(String foodName, int reilang, int danbz, int dianfen, int zf, int tang, int wss) {
        this.foodName = foodName;
        this.reilang = reilang;
        this.danbz = danbz;
        this.dianfen = dianfen;
        this.zf = zf;
        this.tang = tang;
        this.wss = wss;
    }
}
