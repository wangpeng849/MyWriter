package com.wangp.myaop.datastruct;

import java.util.Random;

/**
 * @Author wangp
 * @Date 2020/5/15
 * @Version 1.0
 */
public class SkipList<T> {
    private static class SkipNode<E> {
        E val;//存储的数据
        double score;//跳跃表按照这个分数值进行从小到大排序。
        SkipNode<E> next, down;//next指针，down指向下一层的指针

        SkipNode() {
        }

        SkipNode(E val, double score) {
            this.val = val;
            this.score = score;
        }
    }

    private static final int max_level = 1 << 6;

    //跳表的数据结构
    private SkipNode<T> top;
    //跳表的深度
    private int level = 0;
    //跳表的抛硬币操作
    private Random random = new Random();

    //默认四重
    public SkipList() {
        this(4);
    }

    //跳表初始化
    public SkipList(int level) {
        this.level = level;
        int i = level;
        SkipNode<T> temp = null;
        SkipNode<T> prev = null;
        while (i-- != 0) {
            temp = new SkipNode<T>(null, Double.MIN_VALUE);
            temp.down = prev;
            prev = temp;
        }
        top = temp;
    }

    /**
     * 产生节点高度
     * 抛硬币
     *
     * @return
     */
    private int getRandomLevel() {
        int lev = 1;
        while (random.nextInt() % 2 == 0) {
            lev++;
        }
        return Math.min(lev, max_level);
    }

    public T get(double score) {
        SkipNode<T> t = top;
        while (t != null) {
            if (t.score == score) {
                return t.val;
            }
            if (t.next == null) {
                if (t.down != null) {
                    t = t.down;
                    continue;
                } else {
                    return null;
                }
            }
            if (t.score > score) {
                t = t.down;
            } else {
                t = t.next;
            }
        }
        return null;
    }

    //blog: https://www.cnblogs.com/ljdblog/p/7645814.html

    public static void main(String[] args) {

    }
}
