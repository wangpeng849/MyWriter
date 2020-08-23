package com.wangp.myaop.design_pattern.structural.bridge;

/**
 * <pre>
 * classname Bank
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/23 21:32
 **/
public abstract class Bank {

    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    abstract Account openAccount();
    

}
