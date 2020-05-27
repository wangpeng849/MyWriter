package com.wangp.myaop.union_find;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 */
public abstract class UnionFind {

    protected int[] parents;

    public UnionFind(int capacity) throws IllegalAccessException {
        if(capacity<0) throw new IllegalAccessException("capacity must be >= 1");
        parents = new int[capacity];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    public abstract int find(int v) throws IllegalAccessException;
    public abstract void union(int v1,int v2) throws IllegalAccessException;

    /**
     * 检查v1,v2是否是同一个集合
     * @param v1
     * @param v2
     * @return
     */
    public boolean isSame(int v1,int v2) throws IllegalAccessException {
        return find(v1) == find(v2);
    }

    protected void rangeCheck(int v) throws IllegalAccessException {
        if(v<0 || v>=parents.length){
            throw new IllegalAccessException("range error");
        }
    }
}
