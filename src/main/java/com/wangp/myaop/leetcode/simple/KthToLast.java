package com.wangp.myaop.leetcode.simple;

import com.wangp.myaop.leetcode.ListNode;

/**
 * <pre>
 * classname KthToLast
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/5 19:09
 **/
public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            node = node.next;
        }
        while (node != null) {
            node = node.next;
            head = head.next;
        }
        return head.val;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(new KthToLast().kthToLast(node, 2));
    }
}
