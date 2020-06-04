package com.wangp.myaop.s_algorithm.back_tracking;

/**
 * @Author wangp
 * @Date 2020/6/3
 * @Version 1.0
 */
public class EightQueens3 {
    /**
     * 八皇后问题
     * 任意两个皇后都不能处于同一列 同一行 和 同一对角线
     */


    public static void main(String[] args) {
        new EightQueens3().place8Queens(8);
    }

    /**
     * 皇后位置
     */
    int[] queens;

    /**
     * 一种多少种摆法
     */
    int ways;
    // 1111 1111
    byte cols;
    // 1111 1111 1111 1111
    short leftTop;
    // 1111 1111 1111 1111
    short rightTop;

    void place8Queens(int n) {
        if (n < 1) return;
        queens = new int[n];
        place(0);
        System.out.println("8皇后一共有" + ways + "种摆法");
    }

    /**
     * 从第row行开始摆放
     *
     * @param row
     */
    void place(int row) {
        if (row == 8) {
            ways++;
            show();
            return;
        }
        for (int col = 0; col < 8; col++) {
            int cv = 1 << col;
            if ((cols & (1 << col)) != 0) continue;
            int lv = 1 << (row - col + 7);
            if ((leftTop & lv) != 0) continue;
            int rv = 1 << (row + col);
            if ((rightTop & rv) != 0) continue;
            //摆放皇后
            queens[row] = col;
            cols |= cv;
            leftTop |= lv;
            rightTop |= rv;
            place(row + 1);
            //回溯原本状态
            cols &= ~cv;
            leftTop &= ~lv;
            rightTop &= ~rv;
        }
    }

    private void show() {
        for (int row = 0; row < queens.length; row++) {
            for (int col = 0; col < queens.length; col++) {
                if (queens[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");

    }
}
