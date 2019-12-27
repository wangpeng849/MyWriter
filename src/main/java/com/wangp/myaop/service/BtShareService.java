package com.wangp.myaop.service;

import org.springframework.web.multipart.MultipartFile;

public interface BtShareService {
    int editMovieInfo(int id, MultipartFile file, String uploadDir);
}
