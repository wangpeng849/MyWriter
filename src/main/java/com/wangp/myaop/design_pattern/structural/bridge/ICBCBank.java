package com.wangp.myaop.design_pattern.structural.bridge;

/**
 * <pre>
 * classname ICBCBank
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/23 21:35
 **/
public class ICBCBank extends Bank {

    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开工商银行账号");
        return super.account;
    }
}
