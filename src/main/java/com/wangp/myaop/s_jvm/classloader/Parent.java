package com.wangp.myaop.s_jvm.classloader;

/**
 * <pre>
 * classname Parent
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/2 9:11
 **/
public class Parent {

    public static void main(String[] args) {
        ClassLoader systemClassLoader = Parent.class.getClassLoader();
        System.out.println("系统类加载器: " + systemClassLoader);
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println("系统类加载器的parent（扩展类加载器）: " + extClassLoader);
        ClassLoader bootClassLoader = extClassLoader.getParent();
        System.out.println("扩展类加载器的parent（启动类加载器）: " + bootClassLoader);
        String bootClassPath = System.getProperty("sun.boot.class.path");
        System.out.println(bootClassPath);
        String extClassPath = System.getProperty("java.ext.dirs");
        System.out.println(extClassPath);
        String appClassPath = System.getProperty("java.class.path");
        System.out.println(appClassPath);
    }
}
