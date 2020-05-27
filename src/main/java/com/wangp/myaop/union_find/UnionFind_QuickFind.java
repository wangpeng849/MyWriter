package com.wangp.myaop.union_find;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 */
public class UnionFind_QuickFind extends UnionFind {

    public UnionFind_QuickFind(int capacity) throws IllegalAccessException {
        super(capacity);
    }

    /**
     * 查找v所属的集合
     * @param v
     * @return
     */
    public int find(int v) throws IllegalAccessException {
        rangeCheck(v);
        return parents[v];
    }

    /**
     * 合并v1 v2  将v1所在元素的所有父节点都嫁接给v2
     * @param v1
     * @param v2
     * @throws IllegalAccessException
     */
    public void union(int v1,int v2) throws IllegalAccessException {
        int p1 = find(v1);
        int p2 = find(v2);
        if(p1 == p2) return;

        for (int i = 0; i < parents.length; i++) {
            if(parents[i] == p1){
                parents[i] = p2;
            }
        }
    }


}
