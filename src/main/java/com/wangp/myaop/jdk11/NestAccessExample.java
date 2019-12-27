package com.wangp.myaop.jdk11;

import java.lang.reflect.Field;

public class NestAccessExample {
    public static class X   {
        void test() throws  Exception{
            Y y = new Y();
            y.y = 1;
            //
            Field field = Y.class.getDeclaredField("y");
            field.setInt(y,2);
        }
    }

    private static class Y{
        private int y;
    }

    public static void main(String[] args) throws Exception {
        new X().test();
    }
}
