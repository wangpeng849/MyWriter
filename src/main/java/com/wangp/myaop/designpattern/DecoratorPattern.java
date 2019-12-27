package com.wangp.myaop.designpattern;

/**
 *  装饰模式
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Drink soya = new Soya();
        System.out.println(soya.money());
        System.out.println(soya.desc());
        //加红豆
        Drink redBeanSoya = new RedBean(soya);
        System.out.println(redBeanSoya.money());
        System.out.println(redBeanSoya.desc());
        //加鸡蛋
        Drink redBeanEggSoya = new Egg(redBeanSoya);
        System.out.println(redBeanEggSoya.money());
        System.out.println(redBeanEggSoya.desc());
        //糖豆浆
        Drink sugerSoya = new Sugar(soya);
        System.out.println(sugerSoya.money());
        System.out.println(sugerSoya.desc());
    }
}


//抽象组件
interface Drink{
    public double money();
    public String desc();
}

//豆浆
class Soya implements  Drink{

    @Override
    public double money() {
        return 5;
    }

    @Override
    public String desc() {
        return "纯豆浆";
    }
}

abstract class DrinkDecorator implements Drink{
    private Drink drink;
    public DrinkDecorator(Drink drink){
        this.drink = drink;
    }

    @Override
    public double money() {
        return drink.money();
    }

    @Override
    public String desc() {
        return drink.desc();
    }
}

//红豆类
class RedBean extends DrinkDecorator{

    public RedBean(Drink drink) {
        super(drink);
    }

    @Override
    public double money() {
        return super.money() + 3.2;
    }

    @Override
    public String desc() {
        return super.desc() + "红豆";
    }
}

//鸡蛋类
class Egg extends DrinkDecorator{

    public Egg(Drink drink) {
        super(drink);
    }

    @Override
    public double money() {
        return super.money() + 3.9;
    }

    @Override
    public String desc() {
        return super.desc() + "鸡蛋";
    }
}

//糖
class Sugar extends DrinkDecorator{

    public Sugar(Drink drink) {
        super(drink);
    }

    @Override
    public double money() {
        return super.money() + 2;
    }

    @Override
    public String desc() {
        return super.desc() + "糖";
    }
}