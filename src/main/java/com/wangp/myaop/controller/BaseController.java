package com.wangp.myaop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangpeng
 */
@RestController
public class BaseController {


    @Autowired
    private BaseService baseService;

    @GetMapping("/async")
    public String test() throws InterruptedException {
//        testAsyncInFunction();
        baseService.test();
        return "OK";
    }

//    @Async
//    public void testAsyncInFunction() throws InterruptedException {
//        Thread.sleep(1000L);
//        System.out.println("in function...");
//    }

    @GetMapping("/tran")
    public String test2() {
        baseService.test2();
        return "ok";
    }
}