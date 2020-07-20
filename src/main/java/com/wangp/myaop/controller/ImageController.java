package com.wangp.myaop.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author wangp
 * @Date 2020/7/16
 * @Version 1.0
 */

@RestController
public class ImageController {

    @ApiOperation(httpMethod = "PUT", value = "修改头像", notes = "wp")
    @PutMapping("/portrait")
    public String portrait(@RequestParam("portrait") MultipartFile portrait) {
        if (portrait.getSize() > 2 * 1024 * 1024) {
            return "FILE_TOO_BIG";
        }
        if (!checkPortraitName(portrait.getOriginalFilename())) {
            return "FILE_FORMAT_ERROR";
        }
        return portraitInService(portrait);
    }

    public String portraitInService(MultipartFile portrait) {
        String fileName = savePortrait(portrait);
        if (fileName == null) return "error";
        return "static/img/" + fileName;

    }

    private String savePortrait(MultipartFile portrait) {
        try {
            String portraitFilename = portrait.getOriginalFilename();
            String suffix = portraitFilename.substring(portraitFilename.lastIndexOf("."));
            String path = ResourceUtils.getURL("classpath:static/img").getPath();
            String fileName = UUID.randomUUID().toString().split("-")[0];
            File file = new File(path + File.separator + fileName + suffix);
            if (!file.exists()) {
                file.createNewFile();
            }
            portrait.transferTo(file);
            return file.getName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean checkPortraitName(String originalFilename) {
        return originalFilename.endsWith("jpg") || originalFilename.endsWith("jpeg") ||
                originalFilename.endsWith("jpe") || originalFilename.endsWith("png");
    }


}
