package com.wangp.myaop.transaction;

/**
 * @Author wangp
 * @Date 2020/5/4
 * @Version 1.0
 */
public interface User1Service {
    void addRequired(User1 record);
    void addRequiredNew(User1 user);
}
