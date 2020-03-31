package com.wangp.myaop.controller;

import com.alibaba.fastjson.JSON;
import com.wangp.myaop.entity.ThymUser;
import com.wangp.myaop.service.BtShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
@RequestMapping("/thyme")
public class ThymeleafController {


    @Autowired
    BtShareService btShareService;

    private String uploadDir = "D://";
    /**
     * 有file文件时
     *
     * @param file     图片file
     */
    @RequestMapping("/editMovieInfo")
    @ResponseBody
    public String editMovieInfo(@RequestParam("id") final int id, @RequestParam("file") MultipartFile file) {
        int result = btShareService.editMovieInfo(id, file, uploadDir);
        if (result > -1) {
            return JSON.toJSONString("true");
        } else {
            return JSON.toJSONString("false");
        }
    }

    @RequestMapping("/test")
    public String test(Model model) {
        Map map = new HashMap<>();
        map.put("msg", "他到底是谁，他撕下伪装后，竟然全是伤痕。");
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
    public String show3(Model model) {
        model.addAttribute("today", new Date());
        model.addAttribute("user", new ThymUser().setName("bruce").setAge(21));
        return "hello3";
    }

    @GetMapping("/test4")
    public String show4(Model model) {
        ThymUser user1 = new ThymUser().setName("bruce1").setAge(20);
        ThymUser user2 = new ThymUser().setName("bruc2e").setAge(24);
        ThymUser user3 = new ThymUser().setName("bruce3").setAge(25);
        ThymUser user4 = new ThymUser().setName("bruce4").setAge(25);
        ThymUser user5 = new ThymUser().setName("bruce5").setAge(20);
        List users = Arrays.asList(user1, user2, user3, user4, user5);
        model.addAttribute("users", users);
        return "hello4";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model){
        if (file.isEmpty()){
            model.addAttribute("message", "The file is empty!");
            return "/msg";
        }
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get("D:\\" + file.getOriginalFilename());
            Files.write(path, bytes);
            model.addAttribute("message", "success");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "/msg";
    }

    @GetMapping("/to")
    public String toUpFilePage(){
        return "upfile";
    }
}
