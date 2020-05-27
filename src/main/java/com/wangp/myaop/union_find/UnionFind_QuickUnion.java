package com.wangp.myaop.union_find;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 */
public class UnionFind_QuickUnion extends UnionFind {

    public UnionFind_QuickUnion(int capacity) throws IllegalAccessException {
        super(capacity);
    }

    /**
     * 通过parents链表不断向上找 直到找到根节点
     * @param v
     * @return
     * @throws IllegalAccessException
     */
    @Override
    public int find(int v) throws IllegalAccessException {
        rangeCheck(v);
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
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
        parents[p1] = p2;
    }
}
