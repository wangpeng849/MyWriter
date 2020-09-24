package com.wangp.myaop.jdk11.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <pre>
 * classname FileTest
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/9/21 20:47
 **/
public class FileTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\path\\test.txt");
        Files.writeString(path, "hello world!!!");
        System.out.println(Files.readString(path, StandardCharsets.UTF_8));
    }
}
