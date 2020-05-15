package com.wangp.myaop.controller;

import com.wangp.myaop.aop.Entity;
//import com.wangp.myaop.mapper.TestMapper;
import com.wangp.myaop.aop.FontTransfer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Enumeration;

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


//    @Autowired
//    private TestMapper testMapper;
//    @RequestMapping("/testM")
//    public String testMapper(){
//        TestEntity aTest = testMapper.getATest();
//        return aTest.toString();
//    }

    @PostMapping("/head")
    public String head(HttpServletRequest request){
        String test = request.getHeader("test");
        return test;
    }

    @PostMapping("/heads")
    public String heads(HttpServletRequest request){
        Enumeration<String> test = request.getHeaders("test");
        String bruce = "";
        while(test.hasMoreElements()){
           bruce+=test.nextElement();
        }

        return bruce;
    }

    @PostMapping("/headName")
    public String headName(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        String bruce = "";
        while(headerNames.hasMoreElements()){
            bruce+=headerNames.nextElement()  +  "\n";
        }
        return bruce;
    }
    @GetMapping("/session")
    public String testSession(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpSession session = request.getSession();
        HttpSession session1 = request.getSession(true);
        System.out.println(session == session1);
        return "oK";
    }


    @GetMapping("/date")
    public String testDate(Date date){
        String s = date.toString();
        return s;
    }

    @GetMapping("/dateStr")
    public String testDate(String date){
        return date;
    }

    @GetMapping("/tran")
    @FontTransfer
    public String transfer(){
        return "去玩儿退只看得见安康卡市场老羞成怒死垃圾费阿李小姐按错了删除最快拿上来就奥斯卡了才能抛弃我就怕才能在现场欺骗我进";
    }
}
