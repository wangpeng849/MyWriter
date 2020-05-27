package com.wangp.myaop.union_find;

import java.util.Arrays;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 * Quick union -基于rank优化 再加路径压缩(Path Compression)
 */
public class UnionFind_QuickUnion_R_PC extends UnionFind_QuickUnion_R {


    public UnionFind_QuickUnion_R_PC(int capacity) throws IllegalAccessException {
        super(capacity);
    }

    @Override
    public int find(int v) throws IllegalAccessException {
        rangeCheck(v);
        if (v!=parents[v]){
           parents[v] = find(parents[v]);
        }
        return parents[v];
    }

}
