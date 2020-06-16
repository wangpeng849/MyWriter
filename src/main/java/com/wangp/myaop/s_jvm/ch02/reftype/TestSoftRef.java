package com.wangp.myaop.s_jvm.ch02.reftype;

import net.bytebuddy.implementation.bytecode.Throw;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/6/16
 * @Version 1.0
 */
public class TestSoftRef {

    public static class User {
        public int id = 0;
        public String name = "";

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        User u = new User(1, "wangp");
        SoftReference<User> userSoft = new SoftReference<>(u);
        u = null;
        System.out.println(userSoft.get());
        System.gc();
        System.out.println("after gc");
        System.out.println(userSoft.get());
        List<byte[]> list = new LinkedList<>();
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("****************" + userSoft.get());
                list.add(new byte[1024 * 1024]);
            }
        } catch (Throwable e) {
            System.out.println("****************" + userSoft.get());
        }
    }
}
