package com.wangp.myaop.controller;

import com.wangp.myaop.entity.MongoUser;
import com.wangp.myaop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangp
 * @Date 2020/1/14
 * @Version 1.0
 */

@RestController
public class MongoDBController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/save")
    public Object saveUser() {
        MongoUser user = new MongoUser();
        user.setId(123l);
        user.setUserName("小明");
        user.setPassWord("123123");
        userRepository.saveUser(user);
        return user;
    }

    @GetMapping("/find")
    public Object findUserByUserName() {
        MongoUser user = userRepository.findUserByUserName("小明");
        System.out.println(user);
        return  user;
    }

    @GetMapping("/update")
    public Object updateUser() {
        MongoUser user = new MongoUser();
        user.setId(222l);
        user.setUserName("小明");
        user.setPassWord("password");
        userRepository.saveUser(user);
        return  findUserByUserName();
    }

    @GetMapping("/del")
    public Object deleteUserById() {
        userRepository.deleteUserById(222l);
        return "del...";
    }
}
