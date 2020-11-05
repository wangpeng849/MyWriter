package com.wangp.myaop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * classname GraceShutdownController
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/10/21 17:41
 **/
@RestController
public class GraceShutdownController {

    @GetMapping("/grace")
    public String grace(@RequestParam long timeout) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("start...");
        Thread.sleep(timeout);
        System.out.println("spend time = " + (System.currentTimeMillis() - start) / 1000);
        return "ok";
    }
}
