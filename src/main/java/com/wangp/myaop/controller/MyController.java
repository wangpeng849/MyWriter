package com.wangp.myaop.controller;

import com.wangp.myaop.aop.Entity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("我的Controller")//@Api是用来描述类的
public class MyController {

    @ApiOperation(value="測試Aop功能",notes = "Farling")  // value 方法的描述  notes 方法备注说明
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="姓名")
    })
    //@ApiImplicitParams：描述多参数
    //@ApiImplicitParam：描述单参数
    @RequestMapping("/test")
    public String myAspect(){
        System.out.println("myAspect Funcion...");
        return "OK";
    }

    @Entity
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="姓名"),
            @ApiImplicitParam(name="id",value="艾迪")
    })
    @RequestMapping("/change/{id}")
    public String changeParam(@PathVariable String id){
        return id;
    }
}
