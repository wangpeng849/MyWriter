package com.wangp.myaop.sort_algorithm.cmp;

/**
 * @Author wangp
 * @Date 2020/5/21
 * @Version 1.0
 */

/**
 *  用来测试排序算法的稳定性
 */
public class Student implements Comparable<Student> {

    private int score;
    private int age;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int score, int age) {
        this.score = score;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }
}
