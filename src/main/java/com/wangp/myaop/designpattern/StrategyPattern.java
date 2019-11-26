package com.wangp.myaop.designpattern;

/**
 * @Author farling
 * @Date 2019/11/26
 *
 * 策略模式是对算法的包装，是把使用算法的责任和算法本身分割开来，委派给不同的对象管理。策
 * 模式通常把一个系列的算法包装到一系列的策略类里面，作为一个抽象策略类的子类。
 * 用一句话来说，就是：“准备一组算法，并将每一个算法封装起来，使得它们可以互换”。
 */
public class StrategyPattern {

    public static void main(String[] args) {
        StrategyContext context = new StrategyContext(new ConcreteStrategyA());
        context.contextInterface();
        System.out.println("------------------------------------------------------------");


        Price price = new Price(100,new LowVipDiscountStrategy());
        System.out.println("普通会员价格:" + price.resultPrice());
        price = new Price(100,new MiddleVipDiscountStrategy());
        System.out.println("中等会员价格:" + price.resultPrice());
        price = new Price(100,new HighVipDiscountStrategy());
        System.out.println("高级会员价格:" + price.resultPrice());
    }
}

interface Strategy{
    void strategyInterface();
}

class ConcreteStrategyA implements Strategy{

    @Override
    public void strategyInterface() {
        System.out.println("具体策略1...");
    }
}

class ConcreteStrategyB implements Strategy{

    @Override
    public void strategyInterface() {
        System.out.println("具体策略2...");
    }
}
class ConcreteStrategyC implements Strategy{

    @Override
    public void strategyInterface() {
        System.out.println("具体策略3...");
    }
}

class StrategyContext{
    private Strategy strategy;


    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface(){
        strategy.strategyInterface();
    }
}

/**
 *假设现在要设计一个贩卖各类书籍的电子商务网站的购物车系统。
 * 一个最简单的情况就是把所有货品的单价乘上数量，但是实际情况肯定比这要复杂。
 * 比如，本网站可能对所有的高级会员提供每本20%的促销折扣；对中级会员提供每本10%的促销折扣；对初级会员没有折扣。
 *　　根据描述，折扣是根据以下的几个算法中的一个进行的：
 *　　算法一：对初级会员没有折扣。
 *　　算法二：对中级会员提供10%的促销折扣。
 *　　算法三：对高级会员提供20%的促销折扣。
 */

interface DiscountStrategy{
    float discount();
}
class LowVipDiscountStrategy implements DiscountStrategy{

    @Override
    public float discount() {
        return 1;
    }
}

class MiddleVipDiscountStrategy implements DiscountStrategy{

    @Override
    public float discount() {
        return 0.9f;
    }
}

class HighVipDiscountStrategy implements DiscountStrategy{

    @Override
    public float discount() {
        return 0.8f;
    }
}

class Price{
    private DiscountStrategy discountStrategy;

    private float curPrice;

    public Price(float curPrice,DiscountStrategy discountStrategy){
        this.curPrice = curPrice;
        this.discountStrategy = discountStrategy;
    }

    public float resultPrice(){
        return curPrice*discountStrategy.discount();
    }
}