package com.wangp.myaop.out;

import lombok.Data;

@Data
public class Robot {
    private int id;
    private String name;
    private String type;

    public static void main(String[] args) {
        Test t = new Test();
        t.start();
        for (; ; ) {
            synchronized (t) {
                if (t.isFlag()) {
                    System.out.println("hello world");
                }
            }
        }
    }
}

class Test extends Thread {
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {

        flag = true;
        System.out.println("flag=" + flag);
    }
}
