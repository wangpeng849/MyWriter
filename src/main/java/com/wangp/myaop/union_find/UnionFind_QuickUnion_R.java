package com.wangp.myaop.union_find;

import java.util.Arrays;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 * Quick union -基于rank优化
 */
public class UnionFind_QuickUnion_R extends UnionFind_QuickUnion {

    protected int[] ranks;

    public UnionFind_QuickUnion_R(int capacity) throws IllegalAccessException {
        super(capacity);
        ranks = new int[capacity];
        Arrays.fill(ranks, 1);
    }


    /**
     * 将v1的根节点嫁接给v2根节点
     *
     * @param v1
     * @param v2
     * @throws IllegalAccessException
     */
    @Override
    public void union(int v1, int v2) throws IllegalAccessException {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;

        if (ranks[p1] < ranks[p2]) {
            parents[p1] = p2;
        } else if (ranks[p1] > ranks[p2]) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;
            ranks[p2] ++; //高度加一
        }
    }
}
