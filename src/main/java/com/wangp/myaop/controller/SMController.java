package com.wangp.myaop.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangp.myaop.mapper.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * classname SMController
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/12/11 16:28
 **/
@RestController
public class SMController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("fetchId")
    public String test() {
        User user = new User();
        user.setAge(100);
        userDAO.update(user,
                new LambdaQueryWrapper<User>()
                        .eq(User::getName, "sdasdas")
                        .eq(User::getPhone, "231231"));
        System.out.println("id --- > " + user.getId());
        return "ok";
    }
}
