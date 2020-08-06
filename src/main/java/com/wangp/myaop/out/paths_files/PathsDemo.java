package com.wangp.myaop.out.paths_files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * classname PathsDemo
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/4 17:33
 **/
public class PathsDemo {

    public static void main(String[] args) throws IOException {
        //构建path
        Path path = Paths.get("C:", "Users", "wangpeng", "Desktop", "city.txt");
        System.out.println(path.getFileName());
        //创建文件
        Path newName = Paths.get("C:", "Users", "wangpeng", "Desktop", "new.txt");
        System.out.println(newName);
        if (!Files.exists(newName)) {
            Files.createFile(newName);
        }
        //创建bufferReader
        BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        String readLine = "";
        while ((readLine = bufferedReader.readLine()) != null) {
            System.out.println(readLine);
        }
        //创建bufferWriter测试写文件
        BufferedWriter bufferedWriter = Files.newBufferedWriter(newName, StandardCharsets.UTF_8);
        bufferedWriter.write("测试文件写入");
        bufferedWriter.flush();
        bufferedWriter.close();
        //遍历文件夹
        Path dir = path.getParent();
        DirectoryStream<Path> paths = Files.newDirectoryStream(dir);
        for (Path subPath : paths) {
            System.out.println(subPath.getFileName());
        }
        //遍历整个文件目录：
        Path project = Paths.get("D:", "ideaProject");
        List<Path> pathList = new ArrayList<>();
        Files.walkFileTree(project, new FindJavaVisitor(pathList));
        System.out.println(pathList);
        //Files功能
        Files.copy(path, System.out);
//        Files.copy(System.in, newName, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(path, newName, StandardCopyOption.REPLACE_EXISTING);
        //读取文件属性
        System.out.println(Files.getLastModifiedTime(path));
        System.out.println(Files.size(path));
        System.out.println(Files.isSymbolicLink(path));
        System.out.println(Files.isDirectory(path));
        System.out.println(Files.readAttributes(path, "*"));
    }

    private static class FindJavaVisitor extends SimpleFileVisitor<Path> {

        private List<Path> result;

        public FindJavaVisitor(List<Path> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            if (file.toString().endsWith(".java")) {
                result.add(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
