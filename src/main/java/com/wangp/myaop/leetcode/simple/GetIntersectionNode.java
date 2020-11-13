package com.wangp.myaop.leetcode.simple;

import com.wangp.myaop.leetcode.ListNode;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * classname GetIntersectionNode
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/6 20:32
 **/
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode head = headA;
//        int lenA = 0;
//        int lenB = 0;
//        while (head != null) {
//            head = head.next;
//            lenA++;
//        }
//        head = headB;
//        while (head != null) {
//            head = head.next;
//            lenB++;
//        }
//        if (lenA < lenB) {
//            head = headB;
//            headB = headA;
//            headA = head;
//        }
//        int skip = Math.abs(lenA - lenB);
//        while (skip != 0) {
//            headA = headA.next;
//            skip--;
//        }
//        while (headA != null) {
//            if (headA == headB) {
//                return headA;
//            }
//            headA = headA.next;
//            headB = headB.next;
//        }
//        return null;

        Map map = new HashMap<>();
        while (headA != null) {
            map.put(headA, ".");
            headA = headA.next;
        }
        while (headB != null) {
            if (map.containsKey(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(0);
        ListNode node8 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        node6.next = node7;
        node7.next = node8;
        node8.next = node3;

        node3.next = node4;
        node4.next = node5;

        System.out.println(new GetIntersectionNode().getIntersectionNode(node1, node6).val);
    }
}
