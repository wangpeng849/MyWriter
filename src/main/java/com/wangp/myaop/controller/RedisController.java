package com.wangp.myaop.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wangp.myaop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping(value = "/redis")
@RestController
public class RedisController {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @RequestMapping(value = "/set")
    public String set(){
        User user = new User(1,"farling",12,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        redisTemplate.opsForValue().set("farling", user);
//        redisTemplate.opsForHash().put("wangp","wp",user);
        Object json = JSON.toJSON(user);
        if(json instanceof String){
            return json.toString();
        }
        String userStr = json.toString();
        User userjson = JSON.parseObject(userStr,User.class);
        System.out.println(userjson);
        return "OK";
    }
 
    @RequestMapping(value = "/get")
    public User get(){
        User userValue = (User) redisTemplate.opsForValue().get("farling");
        User userHash = (User) redisTemplate.opsForHash().get("wangp", "wp");


        return User.mixUser(userValue,userHash);
    }
}