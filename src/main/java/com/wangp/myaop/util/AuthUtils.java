package com.wangp.myaop.util;

/**
 * @Author wangp
 * @Date 2020/5/20
 * @Version 1.0
 */
public class AuthUtils {
    private static final int CREATE  = 1;
    private static final int READ  = 1 << 1;
    private static final int UPDATE  = 1 << 2;
    private static final int DELETE  = 1 << 3;

    private int auth;

    public void addAuth(int add){
        this.auth |= add;
    }

    public static void main(String[] args) {
        int auth = 0;
        if((auth & AuthUtils.CREATE) == AuthUtils.CREATE){
            System.out.println("has 权限");
        }
    }
}
