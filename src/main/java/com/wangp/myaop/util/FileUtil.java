package com.wangp.myaop.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/1/10
 * @Version 1.0
 */
public class FileUtil {

    /**
     * 刪除除關鍵詞外的文件
     *
     * @param file
     * @param names
     */
    public static void deleteFileByNotContainsName(File file, List names) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                deleteFileByNotContainsName(file1, names);
            }
        } else {
            if (!strListContainStr(names, file.getName())) {
                System.out.println(file.getName() + "is deleted..");
                file.delete();
            }
        }
    }


    /**
     * 判斷文件是否存在關鍵詞集合中
     *
     * @param strList
     * @param str
     * @return
     */
    public static boolean strListContainStr(List<String> strList, String str) {
        for (String s : strList) {
            if (str.contains(s)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 刪除空白文件夾
     *
     * @param file
     */
    public static void deleteBlankDirectory(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                file.delete();
            } else {
                for (File file1 : files) {
                    System.out.println(file.getName() + "is deleted..");
                    deleteBlankDirectory(file1);
                }
            }
        }
    }

    /**
     * 修改文件名
     */
    public static void modifyName(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                modifyName(f);
            }
        }
        if (file.getName().startsWith("课堂笔记")) {
            System.out.println(file.getName());
            file.renameTo(new File("./" + file.getParentFile().getName() + "-" + file.getName()));
        }
    }

    /**
     * 后缀删除文件
     *
     * @param file
     * @param suffix
     */
    public static void deleteFileBySuffix(File file, String suffix) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null) {
                return;
            }
            for (File f : files) {
                deleteFileBySuffix(f, suffix);
            }
        }
        if (file.getName().endsWith(suffix)) {
            System.out.println(file.getName());
            file.delete();
        }
    }


    public static void fileToMapFormat(String path) throws IOException {
        File newFile = new File(path.substring(0, path.length() - 4) + "_newFile.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        String line = "";
        String output = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] s = line.split(" ");
            output = "CITY_MAP.put(\"" + s[0] + "\" , \"" + s[2] + "\");\n\t";
            bufferedWriter.write(output);
            bufferedWriter.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        fileToMapFormat("C:\\Users\\wangpeng\\Desktop\\city.txt");
    }
}
