package com.wangp.myaop.design_pattern.structural.bridge;

/**
 * <pre>
 * classname SavingAccount
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/23 21:30
 **/
public class SavingAccount implements Account {

    @Override
    public Account openAccount() {
        System.out.println("打开活期账号");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个活期账号");
    }
}
