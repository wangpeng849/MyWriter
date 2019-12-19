package com.wangp.myaop.controller;

import com.wangp.myaop.entity.ThymUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/thyme")
public class ThymeleafController {

    @RequestMapping("/test")
    public String test(Model model) {
        Map map = new HashMap<>();
        map.put("msg","他到底是谁，他撕下伪装后，竟然全是伤痕。");
        model.addAllAttributes(map);
        return "hello1";
    }


    @GetMapping("/test2")
    public String test2(Model model) {
        ThymUser user = new ThymUser().setAge(20).setName("bruce kunkun")
                .setFriend(new ThymUser().setAge(20).setName("brace"));
        model.addAttribute("user", user);
        return "hello2";
    }

    @GetMapping("/test3")
    public String show3(Model model){
        model.addAttribute("today", new Date());
        model.addAttribute("user",new ThymUser().setName("bruce").setAge(21));
        return "hello3";
    }

    @GetMapping("/test4")
    public String show4(Model model){
        ThymUser user1 = new ThymUser().setName("bruce1").setAge(20);
        ThymUser user2 = new ThymUser().setName("bruc2e").setAge(24);
        ThymUser user3 = new ThymUser().setName("bruce3").setAge(25);
        ThymUser user4 = new ThymUser().setName("bruce4").setAge(25);
        ThymUser user5 = new ThymUser().setName("bruce5").setAge(20);
        List users = Arrays.asList(user1,user2,user3,user4,user5);
        model.addAttribute("users",users);
        return "hello4";
    }
}
