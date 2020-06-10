package com.wangp.myaop.bloom_filter;

import org.springframework.util.Assert;

/**
 * @Author wangp
 * @Date 2020/6/9
 * @Version 1.0
 */
public class BloomFilter<T> {

    /**
     * 二进制向量长度（一共有多少位）
     */
    private int bitSize;

    /**
     * 二进制向量
     */
    private long[] bits;

    /**
     * 哈希函数的个数
     */
    private int hashFuncSize;

    /**
     * @param n 数据规模
     * @param p 误判率
     */
    public BloomFilter(int n, double p) {
        Assert.isTrue(n > 0 && p > 0 && p < 1, "n or p error");
        double ln2 = Math.log(2);
        //求二进制向量的长度
        bitSize = (int) (-(n * Math.log(p)) / (ln2 * ln2));
        //哈希函数的个数
        hashFuncSize = (int) (bitSize * ln2 / n);
//        bits = new long[(int) Math.ceil(bitSize / Long.SIZE)];
        bits = new long[(bitSize + Long.SIZE - 1) / Long.SIZE];
    }

    /**
     * 添加元素
     *
     * @param value
     */
    public boolean put(T value) {
        nullCheck(value);
        int hash1 = value.hashCode();
        int hash2 = hash1 >>> 16;

        boolean result = false;
        for (int i = 1; i <= hashFuncSize; i++) {
            int combineHash = hash1 + (i * hash2);
            if (combineHash < 0) {
                combineHash = ~combineHash;
            }
            //生成一个二进制位的索引
            int index = combineHash % bitSize;
            if(set(index)) result =true;


            //   101010101010
            // | 000001000000     1 << index
            //   101011101010
        }
        return result;
    }

    /**
     * 是否包含元素
     *
     * @return
     */
    public boolean contains(T value) {
        nullCheck(value);
        int hash1 = value.hashCode();
        int hash2 = hash1 >>> 16;

        for (int i = 1; i <= hashFuncSize; i++) {
            int combineHash = hash1 + (i * hash2);
            if (combineHash < 0) {
                combineHash = ~combineHash;
            }
            //生成一个二进制位的索引
            int index = combineHash % bitSize;
            if (!get(index)) return false;
        }
        return true;
    }

    /**
     * 设置index位置的二进位为1
     *
     * @param index
     */
    private boolean set(int index) {
        //找到对应的long
        long value = bits[index / Long.SIZE];
        int bitValue = 1 << (index % Long.SIZE);
        //二进制在long内部索引
        bits[index / Long.SIZE] = value | bitValue;
        return (bitValue & value) == 0;
    }

    /**
     * 查看index位置的二进位的值
     *
     * @param index
     * @return
     */
    private boolean get(int index) {
        /*
              101010111
            & 000001000
            ------------
              000000000

              101010111
            & 000000100
             -----------
              000000100
         */

        return (bits[index / Long.SIZE] & (1 << (index % Long.SIZE))) != 0;
    }

    public void nullCheck(T value) {
        Assert.notNull(value, "Value must not be null");
    }
}
