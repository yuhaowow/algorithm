package com.java.yuhao;

import com.java.yuhao.entity.ListNode;

public class ListType {


    //寻找链表相交节点, 双重遍历
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode first = pHead1;
        ListNode seond = pHead2;
        while (first != seond) {
            first = first == null ? pHead2 : first.next;
            seond = seond == null ? pHead1 : seond.next;
        }
        return first;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + carry;
            carry = sum / 10;
            if (head == null) {
                head = new ListNode(sum % 10);
                tail = head;
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head;

    }

}
