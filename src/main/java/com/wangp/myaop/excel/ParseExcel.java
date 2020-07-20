package com.wangp.myaop.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @Author farling
 * @Date 2019/12/2
 */
public class ParseExcel {


    public void testXlsx(){
        File file = new File("C:\\Users\\Administrator\\Desktop\\pdf\\test.xlsx");
        if(!file.exists()){
            System.out.println("文件不存在");
            return ;
        }
        FileInputStream fis = null;
        Workbook workBook = null;
        try {
            fis = new FileInputStream(file);
            workBook = new XSSFWorkbook(fis); // 使用XSSFWorkbook
            dealWorkBook(workBook); // 将代码封装复用，见下一个方法

        } catch (Exception e) {
            e.printStackTrace();
        } finally{ //关流
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(workBook != null){
                try {
                    workBook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void dealWorkBook(Workbook workBook){
        Sheet sheet = workBook.getSheetAt(0); // 获取第一个sheet
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>(); //第一个参数表示行数 第二个List保存该行的cell数据
        int i = 0;
        for(Row row : sheet){
            map.put(i, new ArrayList<String>());
            for(Cell cell : row){ // 遍历当前行的所有cell
                switch(cell.getCellType()) {
                    case STRING:
                        map.get(i).add(cell.getRichStringCellValue().getString()); // 如果是字符串则保存
                        break;
                    case _NONE:
                        break;
                    case NUMERIC:
                        map.get(i).add(cell.getNumericCellValue()+""); //将数值转换为字符串
                        break;
                    case BOOLEAN:
                        break;
                    case FORMULA:
                        break;
                    case BLANK:
                        break;
                    case ERROR:
                        break;
                }
            }
            i++;
        }
        Set<Integer> keys = map.keySet(); // 以下为遍历 Map看解析结果
        Iterator<Integer> it = keys.iterator();
        while(it.hasNext()){
            List<String> list = map.get(it.next());
            for(String s : list){
                System.out.print(s+"      ");
            }
            System.out.println();
        }
    }
}
