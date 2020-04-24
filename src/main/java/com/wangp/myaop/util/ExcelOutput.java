package com.wangp.myaop.util;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：Deng
 * Date：2020/4/16 18:44
 * ========================
 */
@Data
public class ExcelOutput {

    public List<String> columnNames;
    public List<String> cols;
    public List<Map<String, Object>> datas;
    public String shellName;

}
