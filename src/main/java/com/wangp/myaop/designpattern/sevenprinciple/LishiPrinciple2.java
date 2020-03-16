package com.wangp.myaop.designpattern.sevenprinciple;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/3 8:43
 * <p>
 * 里式替换原则
 */
public class LishiPrinciple2 {

    public static void main(String[] args) {
        Lishi_A a = new Lishi_A();
        System.out.println("11 - 3 = " + a.func1(11, 3));
        System.out.println("1 - 8 = " + a.func1(1, 8));
        System.out.println("-------------------------");
        Lishi_B b = new Lishi_B();
        //因为B类不再继承A类，因为调用者，不会认为func1是减法
        System.out.println("11 + 3 = " + b.func1(11, 3));
        System.out.println("1 + 8 = " + b.func1(1, 8));
        System.out.println("11 + 3 + 9 = " + b.func2(11, 3));
        //11 - 3 = 8
        //1 - 8 = -7
        //-------------------------
        //11 + 3 = 14
        //1 + 8 = 9
        //11 + 3 + 9 = 23
    }
}

class Base {
    //把更基础的方法和成员写到积累
}

class Lishi_NewA extends Base {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class Lishi_NewB extends Base {
    Lishi_NewA a = new Lishi_NewA();

    public int func1(int num1,int num2){
        return num1 + num2;
    }
    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }
    public int func3(int a,int b){
        return this.a.func1(a,b);
    }
}