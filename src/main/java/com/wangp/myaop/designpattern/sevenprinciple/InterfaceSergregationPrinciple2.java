package com.wangp.myaop.designpattern.sevenprinciple;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/2 9:26
 */
public class InterfaceSergregationPrinciple2 {
    public static void main(String[] args) {
        NewA A = new NewA();
        A.depend1(new NewB());
        A.depend2(new NewB());
        A.depend3(new NewB());
        NewC C = new NewC();
        C.depend1(new NewD());
        C.depend4(new NewD());
        C.depend5(new NewD());
        //B 实现了 operation1
        //B 实现了 operation2
        //B 实现了 operation3
        //D 实现了 operation1
        //D 实现了 operation4
        //D 实现了 operation5
    }
}

interface Interface2{
    void operation1();
}
interface Interface3{
    void operation2();
    void operation3();
}
interface Interface4{
    void operation4();
    void operation5();
}

class NewB implements Interface2,Interface3{

    @Override
    public void operation1() {
        System.out.println("B 实现了 operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了 operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了 operation3");
    }
}

class NewD implements Interface2,Interface4{

    @Override
    public void operation1() {
        System.out.println("D 实现了 operation1");
    }


    @Override
    public void operation4() {
        System.out.println("D 实现了 operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D 实现了 operation5");
    }
}

class NewA{  //A类通过接口Interface2 Interface3依赖B类，但是只会用到1 2 3方法
    public void depend1(Interface2 i){
        i.operation1();
    }
    public void depend2(Interface3 i){
        i.operation2();
    }
    public void depend3(Interface3 i){
        i.operation3();
    }
}

class NewC{  //C类通过接口Interface2 Interface4依赖D类，但是只会用到1 2 3方法
    public void depend1(Interface2 i){
        i.operation1();
    }
    public void depend4(Interface4 i){
        i.operation4();
    }
    public void depend5(Interface4 i){
        i.operation5();
    }
}