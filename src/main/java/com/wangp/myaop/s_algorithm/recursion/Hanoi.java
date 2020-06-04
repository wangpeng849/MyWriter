package com.wangp.myaop.s_algorithm.recursion;

/**
 * @Author wangp
 * @Date 2020/6/3
 * @Version 1.0
 */
public class Hanoi {
    /**
     * 将n个碟子从p1挪到p3
     * p2为中间的柱子
     * @param n
     * @param p1
     * @param p2
     * @param p3
     *
     * 当n==1 直接盘子从A到C
     * 当n>1时 分三个步骤
     * 1. 将n-1个盘子从A移动到B
     * 2. 将编号n的盘子从A移动到C
     * 3. 将n-1个盘子从B移动到C
     */
    void hanoi(int n,String p1,String p2,String p3){
        if(n == 1){
            move(n,p1,p3);
            return;
        }
        hanoi(n-1,p1,p3,p2);
        move(n,p1,p3);
        hanoi(n-1,p2,p1,p3);
    }

    void move(int no,String from,String to){
        System.out.println("将" + no + " 号盘子从 " + from + " 移动到 " + to);
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(3,"A","B","C");
    }
}
