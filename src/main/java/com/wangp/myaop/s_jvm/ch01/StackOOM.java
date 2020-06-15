package com.wangp.myaop.s_jvm.ch01;

/**
 * @Author wangp
 * @Date 2020/6/15
 * @Version 1.0
 */
public class StackOOM {

    private int stackLength = 1;

    private void diGui(int x,String y) {
        stackLength++;
        diGui(x,y);
    }

//    java.lang.StackOverflowError 考虑是否有无限递归
    public static void main(String[] args) {
        StackOOM oom = new StackOOM();
        try {
//            oom.diGui();            //stackLength = 4353
            oom.diGui(12,"Wangp"); //stackLength = 4263
        } catch (Throwable e) {
            System.out.println("stackLength = " + oom.stackLength);
            e.printStackTrace();
        }
    }
}
