package com.wangp.myaop.union_find;

import com.wangp.myaop.union_find.util.Asserts;
import com.wangp.myaop.union_find.util.Times;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 */
public class Main {

    final static int count = 5000000;


    public static void main(String[] args) throws IllegalAccessException {
//        test(new UnionFind_QuickFind(12));
//        test(new UnionFind_QuickUnion(12));
//        test(new UnionFind_QuickUnion_S(12));
//        test(new UnionFind_QuickUnion_R_PC(12));

//        testTime(new UnionFind_QuickFind(count));
//        testTime(new UnionFind_QuickUnion(count));
        testTime(new UnionFind_QuickUnion_S(count));
        testTime(new UnionFind_QuickUnion_R(count));
        testTime(new UnionFind_QuickUnion_R_PC(count));
        testTime(new UnionFind_QuickUnion_R_PS(count));
        testTime(new UnionFind_QuickUnion_R_PH(count));

    }

    static void test(UnionFind uf) throws IllegalAccessException {
        uf.union(0, 1);
        uf.union(0, 3);
        uf.union(0, 4);
        uf.union(2, 3);
        uf.union(2, 5);

        uf.union(6, 7);

        uf.union(8, 10);
        uf.union(9, 10);
        uf.union(9, 11);
        Asserts.test(!uf.isSame(0, 6));
        uf.union(2, 7);
        Asserts.test(uf.isSame(0, 6));
    }

    static void testTime(UnionFind uf) throws IllegalAccessException {
        Times.test(uf.getClass().getSimpleName(),()->{
            for (int i = 0; i < count; i++) {
                uf.union((int) (Math.random() * count), (int) (Math.random() * count));
            }
            for (int i = 0; i < count; i++) {
                uf.isSame((int) (Math.random() * count), (int) (Math.random() * count));
            }
        });
    }
}
