package com.wangp.myaop.util;

import com.csvreader.CsvWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * classname CsvFile
 * description
 * 逗号分隔值（Comma-Separated Values，CSV，有时也称为字符分隔值，因为分隔字符也可以不是逗号），
 * 其文件以纯文本形式存储表格数据（数字和文本）。纯文本意味着该文件是一个字符序列，不含必须像二进制数字那样被解读的数据。
 * CSV文件由任意数目的记录组成，记录间以某种换行符分隔；每条记录由字段组成，字段间的分隔符是其它字符或字符串，最常见的是逗号或制表符。
 * 通常，所有记录都有完全相同的字段序列。通常都是纯文本文件。建议使用WORDPAD或是记事本（NOTE）来开启，
 * 再则先另存新档后用EXCEL开启，也是方法之一。
 * </pre>
 *
 * @author wangpeng
 * @date 2021/2/2 11:32
 **/
public class CsvFile {

    /**
     * 写CSV
     *
     * @param outputStream 输出流
     * @param headers      表头
     * @param content      内容
     * @throws IOException
     */
    public static void write(OutputStream outputStream, List<String> headers, List<List<String>> content)
            throws IOException {
        write(outputStream, headers.toArray(new String[0]), content);
    }


    /**
     * 写CSV
     *
     * @param filePath 文件路径
     * @param headers  标题
     * @param content  内容
     */
    public static void write(String filePath, List<String> headers, List<List<String>> content)
            throws IOException {
        write(filePath, headers.toArray(new String[0]), content);
    }


    /**
     * 写CSV
     *
     * @param filePath 文件路径
     * @param headers  标题
     * @param content  内容
     * @throws IOException
     */
    public static void write(String filePath, String[] headers, List<List<String>> content)
            throws IOException {
        // 获取 csvWriter
        CsvWriter csvWriter = new CsvWriter(filePath, ',', StandardCharsets.UTF_8);
        // 写入表头
        csvWriter.writeRecord(headers);
        // 写内容
        for (List<String> line : content) {
            csvWriter.writeRecord(line.toArray(new String[0]));
        }

        // 关闭资源
        csvWriter.close();
    }

    /**
     * 写csv
     *
     * @param outputStream 输出流
     * @param headers      表头
     * @param content      内容
     * @throws IOException
     */
    public static void write(OutputStream outputStream, String[] headers, List<List<String>> content)
            throws IOException {
        // 获取 csvWriter
        CsvWriter csvWriter = new CsvWriter(outputStream, ',', StandardCharsets.UTF_8);
        // 写入表头
        csvWriter.writeRecord(headers);
        // 写内容
        for (List<String> line : content) {
            csvWriter.writeRecord(line.toArray(new String[0]));
        }

        // 关闭资源
        csvWriter.close();
    }


    public static void main(String[] args) throws IOException {
        List<String> headers = Arrays.asList("姓名", "年龄", "性别");
        List<String> content1 = Arrays.asList("张三1", "18", "男");
        List<String> content2 = Arrays.asList("张三2", "18", "男");
        List<String> content3 = Arrays.asList("张三3", "18", "男");
        List<List<String>> content = Arrays.asList(content1, content2, content3);
        write("./test.csv", headers, content);
    }
}
