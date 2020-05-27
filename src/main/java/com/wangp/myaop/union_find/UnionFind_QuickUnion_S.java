package com.wangp.myaop.union_find;

import java.util.Arrays;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 * Quick union -基于size优化
 */
public class UnionFind_QuickUnion_S extends UnionFind_QuickUnion {

    private int[] sizes;

    public UnionFind_QuickUnion_S(int capacity) throws IllegalAccessException {
        super(capacity);
        sizes = new int[capacity];
        Arrays.fill(sizes, 1);
    }


    /**
     * 将v1的根节点嫁接给v2根节点
     * @param v1
     * @param v2
     * @throws IllegalAccessException
     */
    @Override
    public void union(int v1, int v2) throws IllegalAccessException {
        int p1 = find(v1);
        int p2 = find(v2);
        if(p1 == p2) return;

        if (sizes[p1] < sizes[p2]) {
            parents[p1] = p2;
            sizes[p2] += sizes[p1];
        } else{
            parents[p2] = p1;
            sizes[p1]+=sizes[p2];
        }
    }
}
