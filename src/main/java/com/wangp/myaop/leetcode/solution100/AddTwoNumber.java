package com.wangp.myaop.leetcode.solution100;

import com.wangp.myaop.leetcode.ListNode;

/**
 * <pre>
 * classname AddTwoNumber
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/3/3 14:26
 **/
public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            if (res == null) {
                tail = res = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(1);
        }
        return res;
    }

    //输入：l1 = [2,4,3], l2 = [5,6,4]
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = new AddTwoNumber().addTwoNumbers(l1, l2);
        listNode.print();
    }
}
