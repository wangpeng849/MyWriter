package com.wangp.myaop.transaction;

/**
 * @Author wangp
 * @Date 2020/5/4
 * @Version 1.0
 */
public interface User2Service {
    void addRequired(User2 record);
    void addRequiredException(User2 user);
    void addRequiresNew(User2 user);
}
