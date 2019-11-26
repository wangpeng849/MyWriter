package com.wangp.myaop.coding;

/**
 * @Author farling
 * @Date 2019/11/25
 *
 *  00000000 - 9999999  8位数 不出现3/4/7
 */
public class ShopID {
    public static final int MAX_NUM = 99999999;

    public static void function(){
        System.out.println("符合店铺id的总数有："+(int) Math.pow(7,8));
        String curId = "";
        for (int i = 0; i < MAX_NUM; i++) {
            if((i+"").contains("3")||(i+"").contains("4")||(i+"").contains("7")){
                continue;
            }
            String zeroStr = "";
            for (int j = 0; j < 8-getPosition(i); j++) {
                 zeroStr+="0";
            }
            curId += zeroStr;
            System.out.println("id:"+(curId+i));
            curId="";
        }
    }

    public static int getPosition(int num){
       return (num+"").length();
    }

    public static void main(String[] args) {
        function();
        System.out.println(getPosition(10));
    }
}
