package com.wangp.myaop.out;

import com.knowledgebase.constant.ResponseEnum;
import com.knowledgebase.constant.ServerResponse;
import com.knowledgebase.service.UpAndDownLoadService;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@Service
public class UpAndDownLoadServiceImpl implements UpAndDownLoadService {

    private final String FILE_PATH = "\\src\\main\\resources\\static\\file\\";
    private final String REDIS_KEY = "FieldConfig";

//    @Override
//    public ServerResponse uploadFile(MultipartFile excel) throws FileNotFoundException {
//        String filename = excel.getOriginalFilename();
//        File file = new File(fileDir(filename));
//        try {
//            excel.transferTo(file);
//        } catch (Exception e) {
//            return ServerResponse.errorResponse(ResponseEnum.FAILED, e.getMessage());
//        }
//        return ServerResponse.successResponse(ResponseEnum.SUCCESS, filename + "上传成功");
//    }
//    @Override
//    public ServerResponse currentFileList() throws FileNotFoundException {
//        File file = new File(fileDir(""));
//        return ServerResponse.successResponse(ResponseEnum.SUCCESS, Arrays.stream(file.listFiles()).map(File::getName).collect(Collectors.toList()));
//    }

    @Override
    public ServerResponse downloadFile(HttpServletResponse response, String filename) throws IOException {
//        ClassPathResource resource = new ClassPathResource("/static/file/"+filename);
//        String path = fileDir(filename);
        File file = new File(uploadPath + "\\" +filename);
        InputStream fis = new FileInputStream(file);
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        // response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + filename);
        byte[] buffer = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null; //输出流
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(fis);
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.errorResponse(ResponseEnum.FAILED, e.toString());
        }
        try {
            bis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ServerResponse readExcelFile(MultipartFile excel) throws IOException {
        Workbook workbook = getWorkbook(excel);
        List<String> fieldNames = new ArrayList<>();
        if (workbook == null) {
            return ServerResponse.errorResponse(ResponseEnum.FAILED);
        } else {
            //获取一个sheet也就是一个工作簿
            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            if (lastRowNum <= 0) {
                return ServerResponse.errorResponse(ResponseEnum.FAILED, "empty file.");
            }
            //从第一行开始第一行一般是标题
            Row row = sheet.getRow(0);
            for (Cell cell : row) {
                if (cell != null) {
//                    cell.setCellType(Cell.CELL_TYPE_STRING);
//                    ListOperations listOperations = redisTemplate.opsForList();
//                    listOperations.rightPush(REDIS_KEY,cell.getStringCellValue());
                    fieldNames.add(cell.getStringCellValue());
                }
            }
        }
        return ServerResponse.successResponse(ResponseEnum.SUCCESS, fieldNames);
    }




    private Workbook getWorkbook(MultipartFile file) throws IOException {
        //获取文件的名字
        String originalFilename = file.getOriginalFilename();
        Workbook workbook = null;
        if (originalFilename.endsWith(".xls")) {
            workbook = new HSSFWorkbook(file.getInputStream());
        } else if (originalFilename.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        }
        return workbook;
    }

    private String fileDir(String filename) throws FileNotFoundException {
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        return path.getPath() + "\\static\\file\\" + filename;
    }

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public ServerResponse upload(MultipartFile excel) throws IOException {
        File file = new File(uploadPath, excel.getOriginalFilename());
        excel.transferTo(file);
        return ServerResponse.successResponse(ResponseEnum.SUCCESS,excel.getOriginalFilename() + "上传成功");
    }
}
