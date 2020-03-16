package com.wangp.myaop.designpattern.sevenprinciple;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 8:43
 *
 * 里式替换原则
 * 由于继承关系造成的错误
 */
public class LishiPrinciple1 {

    public static void main(String[] args) {
        Lishi_A  a = new Lishi_A();
        System.out.println("11 - 3 = "+a.func1(11,3));
        System.out.println("1 - 8 = "+a.func1(1,8));
        System.out.println("-------------------------");
        Lishi_B b = new Lishi_B();
        System.out.println("11 - 3 = "+b.func1(11,3));
        System.out.println("1 - 8 = "+b.func1(1,8));
        System.out.println("11 + 3 + 9 = "+b.func2(11,3));
        //11 - 3 = 8
        //1 - 8 = -7
        //-------------------------
        //11 - 3 = 14
        //1 - 8 = 9
        //11 + 3 + 9 = 23
    }
}

class Lishi_A{
    //无意识重写了func1
    public int func1(int num1,int num2){
        return num1 - num2;
    }
}
class Lishi_B extends Lishi_A{
    public int func1(int num1,int num2){
        return num1 + num2;
    }
    public int func2(int a, int b ){
        return func1(a,b)+9;
    }
}
