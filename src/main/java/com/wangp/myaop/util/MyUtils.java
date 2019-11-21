package com.wangp.myaop.util;

import lombok.Data;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

@Data
public class MyUtils {
    
    List<Student> studentList;
    
    @Data
    static class Student{
        private String name;
        private int age;
        private double balance;

        private int protectValue;//用来计算
    }


    public static void main(String[] args) {
        MyUtils.Student stu1 = new MyUtils.Student();
        stu1.setName("AAA");
        stu1.setAge(20);
        
        MyUtils.Student stu2 = new MyUtils.Student();
        stu2.setName("BBB");
        stu2.setAge(25);
        
        MyUtils.Student stu3 = new MyUtils.Student();
        stu3.setName("CCC");
        stu3.setAge(30);

        MyUtils utils = new MyUtils();
        utils.setStudentList(Arrays.asList(stu1,stu2,stu3));

        int sum = utils.getStudentList()
                .stream()
                .mapToInt(Student::getAge)
                .sum();
        System.out.println("sum = " + sum);

        long count = utils.getStudentList()
                .stream()
                .mapToInt(Student::getAge)
                .count();
        System.out.println("count = "+ count);

        utils.getStudentList()
                .stream()
                .forEach(student ->student.setBalance(student.getAge()/(float)sum));

        System.out.println("list ->" + utils.getStudentList());

        for (int i = 1; i <= utils.getStudentList().size(); i++) {
            int value = utils.getStudentList()
                    .stream()
                    .skip(i)
                    .mapToInt(Student::getAge)
                    .sum();

            System.out.println(value);
//            utils.getStudentList()
//                    .stream()
//                    .forEach(student ->student.setBalance(student.getAge()/(float)value));
        }

        IntSummaryStatistics num = utils.getStudentList()
                .stream()
                .mapToInt(u -> u.getAge())
                .summaryStatistics();
        System.out.println("总共人数：" + num.getCount());
        System.out.println("平均年龄：" + num.getAverage());
        System.out.println("最大年龄：" + num.getMax());
        System.out.println("最小年龄：" + num.getMin());
        System.out.println("年龄之和：" + num.getSum());
    }
}
