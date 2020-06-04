package com.wangp.myaop.s_algorithm.back_tracking;

import java.util.List;

/**
 * @Author wangp
 * @Date 2020/6/3
 * @Version 1.0
 */
public class EightQueens {
    /**
     * 八皇后问题
     * 任意两个皇后都不能处于同一列 同一行 和 同一对角线
     */


    /**
     * 1.暴力除奇迹
     * <p>
     * C64取8 = 4.4*10^9
     * <p>
     * <p>
     * 2.减少暴力
     * 每一行只放一个皇后  共有8^8摆法
     * <p>
     * <p>
     * 3.回溯法
     * --->
     */


    public static void main(String[] args) {
        new EightQueens().placeQueens(4);
    }

    /**
     * 数组索引是行号，数组元素是列号 cols[4]=5   cols[row]=col
     */
    int[] cols;
    /**
     * 一种多少种摆法
     */
    int ways;

    void placeQueens(int n) {
        if (n < 1) return;
        cols = new int[n];
        place(0);
        System.out.println(n + "皇后一共有" + ways + "种摆法");
    }

    /**
     * 从第row行开始摆放
     *
     * @param row
     */
    void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                //摆放皇后
                cols[row] = col;
                place(row + 1);
            }
        }
    }

    private void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");

    }

    /**
     * 判断第row行 第col列是否可以摆放皇后
     *
     * @param row
     * @param col
     * @return
     */
    boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            //第col列有皇后
            if (cols[i] == col) {
//                System.out.println("[" + row + "][" + col + "]=false");
                return false;
            }
            //第i行的皇后 跟第row斜线有皇后
            if ((row - i) == Math.abs(col - cols[i])) {
//                System.out.println("[" + row + "][" + col + "]=false");
                return false;
            }
        }
//        System.out.println("[" + row + "][" + col + "]=true");
        return true;
    }
}
