package com.wangp.myaop.designpattern;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author farling
 * @Date 2019/11/26
 * <p>
 * 模板方法模式是类的行为模式。
 * 准备一个抽象类，将部分逻辑以具体方法以及具体构造函数的形式实现，然后声明一些抽象方法来迫使子类实现剩余的逻辑。
 * 不同的子类可以以不同的方式实现这些抽象方法，从而对剩余的逻辑有不同的实现。这就是模板方法模式的用意。
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {
        Account account = new CDAccount();
        System.out.println(account.doCalculateAccountType()+"'s interest is "+account.calculateInterest());
        account = new MoneyMarketAccount();
        System.out.println(account.doCalculateAccountType()+"'s interest is "+account.calculateInterest());
    }
}

abstract class AbstractTemplate {
    /**
     * 模板方法
     */
    public void templateMethod() {
        abstractMethod();
        hookMethod();
        concreteMethod();
    }

    /**
     * 基本方法的声明（由子类实现）
     */
    protected abstract void abstractMethod();

    /**
     * 基本方法(空方法)
     */
    protected void hookMethod() {
    }

    /**
     * 基本方法（已经实现）
     */
    private final void concreteMethod() {
        //业务相关的代码
        System.out.println("concreteMethod 实现..");
    }
}

class ConcreteTemplate extends AbstractTemplate {
    //基本方法的实现
    @Override
    public void abstractMethod() {
        //业务相关的代码
    }

    //重写父类的方法
    @Override
    public void hookMethod() {
        //业务相关的代码
    }
}

/**
 * 考虑一个计算存款利息的例子。假设系统需要支持两种存款账号，
 * 即货币市场(Money Market)账号和定期存款(Certificate of Deposite)账号。这两种账号的存款利息是不同的，
 * 因此，在计算一个存户的存款利息额时，必须区分两种不同的账号类型。
 * 　　 这个系统的总行为应当是计算出利息，这也就决定了作为一个模板方法模式的顶级逻辑应当是利息计算。
 * 由于利息计算涉及到两个步骤：一个基本方法给出账号种类，另一个基本方法给出利息百分比。
 * 这两个基本方法构成具体逻辑，因为账号的类型不同，所以具体逻辑会有所不同。
 * 　　 显然，系统需要一个抽象角色给出顶级行为的实现，而将两个作为细节步骤的基本方法留给具体子类实现。
 * 由于需要考虑的账号有两种：一是货币市场账号，二是定期存款账号。
 */

abstract class Account {
    public final double calculateInterest() {
        double interestRate = doCalculateInterestRate();
        String accountType = doCalculateAccountType();
        double amount = calculateAmount(accountType);
        return amount * interestRate;
    }

    /**
     * 基本方法留给子类实现
     */
    protected abstract String doCalculateAccountType();

    /**
     * 基本方法留给子类实现
     */
    protected abstract double doCalculateInterestRate();

    /**
     * 基本方法，已经实现
     */
    private double calculateAmount(String accountType) {
        /**
         * 省略相关的业务逻辑
         */
        return 7243.00;
    }
}

class MoneyMarketAccount extends Account {

    @Override
    protected String doCalculateAccountType() {

        return "Money Market";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.045;
    }
}

class CDAccount extends Account {

    @Override
    protected String doCalculateAccountType() {
        return "Certificate of Deposite";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.06;
    }

}