package com.wangp.myaop.datastruct;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * @Author wangp
 * @Date 2020/4/23
 * @Version 1.0
 */
public class SetTest {

    static class Student{
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

    }

    public static void main(String[] args) {
        Student stu1 = new Student("A",12);
        Student stu2 = new Student("B",13);
        Set set = new HashSet();
        set.add(stu1);
        set.add(stu2);
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
