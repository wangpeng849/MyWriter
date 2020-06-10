package com.wangp.myaop.skip_list;

import com.wangp.myaop.union_find.util.Asserts;
import com.wangp.myaop.union_find.util.Times;

import java.util.TreeMap;

/**
 * @Author wangp
 * @Date 2020/6/10
 * @Version 1.0
 *
 *
 * 小拓展：
 *      为什么MySQL不用B树而用B+树？
 *      为了提高IO操作效率，会把一个节点设置为最小读写单位
 *          MySQL 的存储引擎InnoDB的最小读写是16k
 *      对比B树，B+树的优势是：
 *          每个节点存储的key数量更多，树的高度更低
 *          所有的具体数据都存在叶子节点，查询速度比较稳定
 *          叶子节点构成了有序链表，区间查询更方便
 *      +----------+             +----------+           +----------+
 *      | 客户端   |     <-->    | 服务器   |   <-->    | 数据库   |
 *      +---------+             +---------+            +---------+
 *      优化读取数据库，相当于优化IO操作
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        SkipList<Integer, Integer> list = new SkipList<>();
        test(list,100,10);
//        time();
    }


    private static void time() throws IllegalAccessException {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        SkipList<Integer, Integer> list = new SkipList<>();
        int count = 100_0000;
        int delta = 10;

        Times.test("TreeMap", () -> {
            test(map, count, delta);
        });

        Times.test("SkipList", () -> {
            test(list, count, delta);
        });

    }

    private static void test(SkipList<Integer, Integer> list, int count, int delta) {
        for (int i = 0; i < count; i++) {
            list.put(i, i + delta);
        }
		System.out.println(list);
        for (int i = 0; i < count; i++) {
            Asserts.test(list.get(i) == i + delta);
        }
        Asserts.test(list.size() == count);
        for (int i = 0; i < count; i++) {
            Asserts.test(list.remove(i) == i + delta);
        }
        Asserts.test(list.size() == 0);
    }

    private static void test(TreeMap<Integer, Integer> map, int count, int delta) {
        for (int i = 0; i < count; i++) {
            map.put(i, i + delta);
        }
        for (int i = 0; i < count; i++) {
            Asserts.test(map.get(i) == i + delta);
        }
        Asserts.test(map.size() == count);
        for (int i = 0; i < count; i++) {
            Asserts.test(map.remove(i) == i + delta);
        }
        Asserts.test(map.size() == 0);
    }

}
