package com.wangp.myaop.union_find;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 * Quick union -基于rank优化 再加路径减半(Path Halving )
 */
public class UnionFind_QuickUnion_R_PH extends UnionFind_QuickUnion_R {

    public UnionFind_QuickUnion_R_PH(int capacity) throws IllegalAccessException {
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
