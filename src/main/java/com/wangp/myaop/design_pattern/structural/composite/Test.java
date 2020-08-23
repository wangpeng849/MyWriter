package com.wangp.myaop.design_pattern.structural.composite;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/23 15:55
 **/
public class Test {

    public static void main(String[] args) {
        CatalogComponent linuxCourse = new Course("Linux课程", 11);
        CatalogComponent windowsCourse = new Course("Windows课程", 22);
        CatalogComponent javaCourseCatalog = new CourseCatalog("Java课程目录", 2);
        CatalogComponent course1 = new Course("Java课程1", 10);
        CatalogComponent course2 = new Course("Java课程2", 20);
        javaCourseCatalog.add(course1);
        javaCourseCatalog.add(course2);

        CatalogComponent allCourse = new CourseCatalog("主目录", 1);
        allCourse.add(linuxCourse);
        allCourse.add(windowsCourse);
        allCourse.add(javaCourseCatalog);

        CatalogComponent designPatternCatalog = new CourseCatalog("设计模式", 3);
        CatalogComponent designPatternCourse = new Course("设计模式课程", 1);
        designPatternCatalog.add(designPatternCourse);
        javaCourseCatalog.add(designPatternCatalog);

        allCourse.print();
    }
}
