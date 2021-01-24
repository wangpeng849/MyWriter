package com.wangp.myaop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * classname TestService
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/1/4 17:28
 **/
@Component
public class BaseService {

    @Autowired
    private UserMapper userMapper;


    @Async
    public void test() throws InterruptedException {
        Thread.sleep(1000L);
        System.out.println("service test...");
    }

    @Transactional(timeout = 30, rollbackFor = Exception.class)
    public void test2() {
        User user = userMapper.getUser();
        System.out.println(user);
    }
}
