package com.wangp.myaop.union_find;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author wangp
 * @Date 2020/5/27
 * @Version 1.0
 */
public class GenericUnionFind<V> {

    private Map<V, Node<V>> nodes = new HashMap<>();

    //将对象成节点
    public void makeSet(V v) {
        if (nodes.containsKey(v)) return;
        nodes.put(v, new Node<>(v));
    }

    /**
     * 找到v的根节点
     *
     * @param v
     * @return
     */
    private Node<V> findNode(V v) {
        Node<V> node = nodes.get(v);
        if (node == null) return null;

        while (!Objects.equals(node.value, node.parent.value)) {
            node.parent = node.parent.parent;
            node = node.parent;
        }
        return node;
    }

    public V find(V v) {
        Node<V> node = findNode(v);
        return node == null ? null : node.value;
    }

    public void union(V v1, V v2) {
        Node<V> node1 = findNode(v1);
        Node<V> node2 = findNode(v2);
        if(node1 == null || node2 == null) return;
        if (Objects.equals(node1.value,node2.value)) return;

        if (node1.rank < node2.rank) {
            node1.parent = node2;
        } else if (node1.rank > node2.rank) {
            node2.parent = node1;
        } else {
            node1.parent = node2;
            node2.rank++;//高度加一
        }
    }

    public boolean isSame(V v1, V v2) {
        return Objects.equals(find(v1), find(v2));
    }

    private static class Node<V> {
        V value;
        Node<V> parent = this;
        int rank = 1;

        public Node(V value) {
            this.value = value;
        }
    }
}
