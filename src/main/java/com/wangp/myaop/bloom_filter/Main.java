package com.wangp.myaop.bloom_filter;

import com.wangp.myaop.union_find.util.Asserts;

/**
 * @Author wangp
 * @Date 2020/6/9
 * @Version 1.0
 */
public class Main {
    /**
     * 布隆过滤器是一个空间效率性数据结构，可以用来告诉你：一个元素一定不存在或者可能存在
     *
     * 优点缺点：
     *     优点： 空间效率和查询时间远远超过一般算法
     *     缺点： 有一定的误判率
     *
     *
     *     实质上是一个很长的二进制向量和一系列的随机映射函数（Hash函数）
     *
     *
     *     常见应用
     *     网页黑名单系统，缓存穿透
     *
     *     添加：利用hash函数生成一对索引 并把每个索引置为1
     *     查询：找到的时候 用hash函数比对每个索引 有一个不为1 就说明不存在 （100%）
     *                                          每一个都为1 代表存在（一定误判率）
     *
     *      误判率p受三个因素影响 ：二进制个数m 函数函数个数k 数据规模n
     *      p = (1 - e ^ -(( k * ( n + 0.5 ))/ (m - 1))^k
     *        = ( 1 - e ^ -(k*n/m) ) ^ k
     *
     *
     *      m = - (n * lnP ) * (ln 2)^ 2                k = (m/n)*ln2          k = -log2 p
     */

    public static void main(String[] args) {
        BloomFilter<Integer> bf = new BloomFilter<>(1_00_0000,0.01);
        for (int i = 1; i <= 500; i++) {
                bf.put(i);
        }
        for (int i = 1; i <= 500; i++) {
            Asserts.test(bf.contains(i));
        }

    }
}
