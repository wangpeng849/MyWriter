package com.wangp.myaop.design_pattern.principle.demeter;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 * 迪米特 最少知道原则
 *
 * @author wangp
 * @date 2020/8/9 21:31
 **/
public class Test {

    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.commandCheckNumber(new TeamLeader());
    }
}
