package com.wangp.myaop.out;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author wangp
 * @Date 2020/4/20
 * @Version 1.0
 */
public interface UpAndDownLoadService {
//    ServerResponse uploadFile(MultipartFile excel) throws FileNotFoundException;
//    ServerResponse currentFileList() throws FileNotFoundException;

    ServerResponse downloadFile(HttpServletResponse response, String filename) throws IOException;
    ServerResponse readExcelFile(MultipartFile excel) throws IOException;
    ServerResponse upload(MultipartFile excel) throws IOException;
}
