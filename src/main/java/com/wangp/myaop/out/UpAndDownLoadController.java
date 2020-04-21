package com.wangp.myaop.out;

import com.knowledgebase.constant.ResponseEnum;
import com.knowledgebase.constant.ServerResponse;
import com.knowledgebase.service.UpAndDownLoadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author wangp
 * @Date 2020/4/20
 * @Version 1.0
 */
@RestController
@Api(value = "文件上传和下载控制器", description = "文件上传和下载控制器")
@RequestMapping("/uad")
public class UpAndDownLoadController {

    @Autowired
    private RedisTemplate redisTemplate;


//    @GetMapping("fieldByFile")
//    @ApiOperation(value = "File-读取文件后得到字段名列表")
//    public ServerResponse fileConfigFromFile(){
//        List<String> fileConfig = redisTemplate.opsForList().range(REDIS_KEY, 0, -1);
//        redisTemplate.delete(REDIS_KEY);
//        return ServerResponse.successResponse(ResponseEnum.SUCCESS,fileConfig);
//    }

    @Autowired
    private UpAndDownLoadService upAndDownLoadService;

    @PostMapping("read")
    @ApiOperation(value = "File-读取excel字段")
    public ServerResponse readFileField(@RequestParam MultipartFile excel) throws IOException {
        try{
            return upAndDownLoadService.readExcelFile(excel);
        }catch (Exception e){
            return ServerResponse.errorResponse(ResponseEnum.FAILED);
        }
    }

//    @PostMapping("upload")
//    @ApiOperation(value = "File -上传excel")
//    public ServerResponse uploadFile(@RequestParam MultipartFile excel) {
//        try{
//            return upAndDownLoadService.uploadFile(excel);
//        }catch (Exception e){
//            return ServerResponse.errorResponse(ResponseEnum.FAILED);
//        }
//    }
//
//    @GetMapping("fileList")
//    @ApiOperation(value = "File - 已保存文档列表")
//    public ServerResponse fileList() {
//        try{
//            return upAndDownLoadService.currentFileList();
//        }catch (Exception e){
//            return ServerResponse.errorResponse(ResponseEnum.FAILED,e.getMessage());
//        }
//    }
//
//    @GetMapping("download")
//    @ApiOperation(value = "File - 文件模板下载")
//    public ServerResponse downloadFile(HttpServletResponse response, String filename) throws IOException {
//        try{
//            return upAndDownLoadService.downloadFile(response, filename);
//        }catch (Exception e){
//            return ServerResponse.errorResponse(ResponseEnum.FAILED,e.getMessage());
//        }
//    }

    @Value("${upload.path}")
    private String uploadPath;

    @ApiOperation("文件上传")
    @PostMapping("upload")
    public ServerResponse jarUpload(@RequestParam MultipartFile excel) throws IOException {
        try {
            return upAndDownLoadService.upload(excel);
        }catch (Exception e){
            return ServerResponse.errorResponse(ResponseEnum.FAILED,e.getMessage());
        }
    }

    @GetMapping("filelist")
    @ApiOperation(value = "当前文件列表")
    public ServerResponse fileLists(){
        try {
            File file = new File(uploadPath);
            return ServerResponse.successResponse(ResponseEnum.SUCCESS, Arrays.stream(file.listFiles()).map(File::getName).collect(Collectors.toList()));
        }catch (Exception e){
            return ServerResponse.errorResponse(ResponseEnum.FAILED,e.getMessage());
        }
    }

    @GetMapping("filedown")
    @ApiOperation(value = "文件下载")
    public ServerResponse down (HttpServletResponse response,String filename) {
        try {
            return upAndDownLoadService.downloadFile(response,filename);
        } catch (IOException e) {
            return ServerResponse.errorResponse(ResponseEnum.FAILED,"没找到资源" + filename);
        }
    }
}
