package com.wangp.myaop.s_algorithm.back_tracking;

/**
 * @Author wangp
 * @Date 2020/6/3
 * @Version 1.0
 */
public class EightQueens2 {
    /**
     * 八皇后问题
     * 任意两个皇后都不能处于同一列 同一行 和 同一对角线
     */


    public static void main(String[] args) {
        new EightQueens2().placeQueens(8);
    }

    /**
     * 皇后位置
     */
    int[] queens;
    /**
     * 标记某一列是否有皇后
     */
    boolean[] cols;
    /**
     * 对角线   左上角 ->右下角
     */
    boolean[] leftTop;
    /**
     * 对角线   右上角 ->左下角
     */
    boolean[] rightTop;
    /**
     * 一种多少种摆法
     */
    int ways;

    void placeQueens(int n) {
        if (n < 1) return;
        cols = new boolean[n];
        queens = new int[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
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
            if (cols[col]) continue;
            int ltIndex = row - col + cols.length - 1;
            if (leftTop[ltIndex]) continue;
            int rtIndex = row + col;
            if (rightTop[rtIndex]) continue;
            //摆放皇后
            queens[row]=col;
            cols[col] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;
            place(row + 1);
            //回溯原本状态
            cols[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;
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
