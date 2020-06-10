package com.wangp.myaop.skip_list;

import org.springframework.util.Assert;

import java.util.Comparator;

/**
 * @Author wangp
 * @Date 2020/6/10
 * @Version 1.0
 */
public class SkipList<K, V> {
    private static final int MAX_LEVEL = 32;//最高32层
    private static final double P = 0.25;//通常为 0.5或者0.25
    private int size;
    private Comparator<K> comparator;
    /**
     * 有效层数
     */
    private int level;

    /**
     * 不存放任何值的首节点
     */
    private Node<K, V> first;

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        first = new Node<>(null, null, MAX_LEVEL);
        first.nexts = new Node[MAX_LEVEL];
    }

    public SkipList() {
        this(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V put(K key, V value) {
        keyCheck(key);
        //从first一层一层往下找
        Node<K, V> node = this.first;
        //存储前驱节点
        Node<K, V>[] prevs = new Node[level];
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            if (cmp == 0) {
                V oldValue = node.nexts[i].value;
                node.nexts[i].value = value;
                return oldValue;
            }
            prevs[i] = node;
        }
        //新节点的层数
        int newLevel = randomLevel();
        // 添加新节点
        Node<K, V> newNode = new Node<>(key, value, newLevel);
        //设置前驱和后继
        for (int i = 0; i < newLevel; i++) {
            if (i >= level) {
                //超过层数时
                first.nexts[i] = newNode;
            } else {
                newNode.nexts[i] = prevs[i].nexts[i];
                prevs[i].nexts[i] = newNode;
            }
        }
        size++;
        //计算最终层数
        level = Math.max(level, newLevel);
        return null;
    }


    /**
     * @param key
     * @return
     */
    public V get(K key) {
        keyCheck(key);
        //从first一层一层往下找
        Node<K, V> node = this.first;
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            if (cmp == 0) return node.nexts[i].value;
        }
        return null;
    }

    public V remove(K key) {
        keyCheck(key);
        //从first一层一层往下找
        Node<K, V> node = this.first;
        //key是否存在
        boolean exist = false;
        //存储前驱节点
        Node<K, V>[] prevs = new Node[level];
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            prevs[i] = node;
            if (cmp == 0) exist = true;
        }
        if (!exist) return null;
        //需要被删除的节点   node是第0层的前驱
        Node<K, V> removeNode = node.nexts[0];
        //节点数减少
        size--;
        //设置后继
        for (int i = 0; i < removeNode.nexts.length; i++) {
            prevs[i].nexts[i] = removeNode.nexts[i];
        }
        //更新跳表层数
        int curLevel = level;
        while (--curLevel >= 0 && first.nexts[curLevel] == null) {
            level = curLevel;
        }
        return removeNode.value;
    }


    private int randomLevel() {
        int level = 1;
        while (Math.random() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    private void keyCheck(K key) {
        Assert.notNull(key, "key must not be null");
    }

    private int compare(K k1, K k2) {
        return comparator != null
                ? comparator.compare(k1, k2)
                 : ((Comparable<K>) k1).compareTo(k2);
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V>[] nexts;


        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            nexts = new Node[level];
        }

        @Override
        public String toString() {
            return key + ":" + value + "_" + nexts.length;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("一共" + level + "层").append("\n");
        for (int i = level - 1; i >= 0; i--) {
            Node<K, V> node = first;
            while (node.nexts[i] != null) {
                sb.append(node.nexts[i]);
                sb.append(" ");
                node = node.nexts[i];
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
