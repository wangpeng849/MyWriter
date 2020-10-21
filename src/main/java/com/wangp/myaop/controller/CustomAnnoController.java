package com.wangp.myaop.controller;

import com.wangp.myaop.anno.RepeatRequestInterception;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * classname CustomAnnoController
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/10/20 20:15
 **/
@RestController
public class CustomAnnoController {


    @GetMapping("custom")
    @RepeatRequestInterception(durationTime = 10)
    public String customAnnotationTest() {
        System.out.println("do something");
        return "OK";
    }
}
