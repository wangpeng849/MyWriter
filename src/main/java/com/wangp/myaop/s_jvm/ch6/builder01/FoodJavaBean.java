package com.wangp.myaop.s_jvm.ch6.builder01;

public class FoodJavaBean {

    //required
    private final String foodName;
    private final int reilang;

    //optional
    private  int danbz;
    private  int dianfen;
    private  int zf;
    private  int tang;
    private   int wss;


    public FoodJavaBean(String foodName, int reilang) {
        this.foodName = foodName;
        this.reilang = reilang;
    }
}
