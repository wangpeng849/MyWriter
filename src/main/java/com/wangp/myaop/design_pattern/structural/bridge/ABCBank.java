package com.wangp.myaop.design_pattern.structural.bridge;

/**
 * <pre>
 * classname ABCBank
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/23 21:34
 **/
public class ABCBank extends Bank {

    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开农业银行账号");
        return super.account;
    }
}
