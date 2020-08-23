package com.wangp.myaop.design_pattern.structural.bridge;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/23 21:32
 **/
public class Test {

    public static void main(String[] args) {
        Bank icbcBank = new ICBCBank(new DepositAccount());
        Account icbcAccount = icbcBank.openAccount();
        icbcAccount.showAccountType();

        Bank abcBank = new ABCBank(new SavingAccount());
        Account abcAccount = abcBank.openAccount();
        abcAccount.showAccountType();
    }
}
