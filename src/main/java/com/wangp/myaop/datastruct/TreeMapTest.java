package com.wangp.myaop.datastruct;

import lombok.Builder;
import lombok.Data;

import java.util.TreeMap;

/**
 * @Author wangp
 * @Date 2020/5/18
 * @Version 1.0
 */
public class TreeMapTest {

    @Data
    @Builder
    static class User implements  Comparable<User>{
        private String name;
        private Integer age;

        @Override
        public int compareTo(User o) {
            return this.age>o.getAge() ? 1:-1;
        }
    }

    public static void main(String[] args) {
        TreeMap<User,Integer> treeMap = new TreeMap<>();
        User user1 = User.builder().name("张三").age(15).build();
        User user2 = User.builder().name("李四").age(17).build();
        User user3 = User.builder().name("张四").age(16).build();
        User user4 = User.builder().name("李三").age(18).build();

        treeMap.put(user1,1);
        treeMap.put(user2,1);
        treeMap.put(user3,1);
        treeMap.put(user4,1);
        System.out.println(treeMap);

        User user = treeMap.lastKey();
        System.out.println(user);
        //User 必须实现Comparable接口
        //否则 报错com.wangp.myaop.datastruct.TreeMapTest$User cannot be cast to java.lang.Comparable
    }
}
