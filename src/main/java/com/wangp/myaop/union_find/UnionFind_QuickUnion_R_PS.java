package com.wangp.myaop.union_find;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 * Quick union -基于rank优化 再加路径分裂(Path Splitting)
 */
public class UnionFind_QuickUnion_R_PS extends UnionFind_QuickUnion_R {

    public UnionFind_QuickUnion_R_PS(int capacity) throws IllegalAccessException {
        super(capacity);
    }

    @Override
    public int find(int v) throws IllegalAccessException {
        rangeCheck(v);
        while (v != parents[v]) {
            parents[v] = parents[parents[v]];
            v = parents[v];
        }
        return v;
    }
}
