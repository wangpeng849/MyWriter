package com.wangp.myaop.design_pattern.structural.bridge;

/**
 * <pre>
 * classname DepositAccount
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/23 21:30
 **/
public class DepositAccount implements Account {

    @Override
    public Account openAccount() {
        System.out.println("打开定期账号");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个定期账号");
    }
}
