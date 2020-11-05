package com.wangp.myaop.leetcode.simple;

/**
 * <pre>
 * classname JudgeCircle
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/5 19:15
 **/
public class JudgeCircle {

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'D') {
                y += 1;
            } else if (moves.charAt(i) == 'R') {
                x += 2;
            }
            if (moves.charAt(i) == 'U') {
                y -= 1;
            } else if (moves.charAt(i) == 'L') {
                x -= 2;
            }
        }
        return y == 0 && x == 0;
    }

    public static void main(String[] args) {
        System.out.println(new JudgeCircle().judgeCircle("LDRRLRUULR"));
    }
}
