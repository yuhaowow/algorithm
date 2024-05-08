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

    //寻找链表相交节点, 双重遍历
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode first = pHead1;
        ListNode seond = pHead2;
        while (first != seond) {
            first = first == null ? pHead2 : first.next;
            seond = seond == null ? pHead1 : seond.next;
        }
        return first;
    }

    //    反转链表 迭代法
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    //   环形链表入口节点判断
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 定义快慢指针
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            // 快指针是满指针的两倍速度
            fast = fast.next.next;
            slow = slow.next;
            // 记录快慢指针第一次相遇的结点
            if (slow == fast) {
                break;
            }
        }
        // 若是快指针指向null，则不存在环
        if (fast == null || fast.next == null) {
            return null;
        }
        // 重新指向链表头部
        fast = pHead;
        // 与第一次相遇的结点相同速度出发，相遇结点为入口结点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    // 回文链表
    public static boolean isPail(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // write code here
        ListNode p = head;
        int l = 0;
        while (p != null) {
            l++;
            p = p.next;
        }
        int mid = l / 2;
        ListNode middle = head;
        while (mid != 0) {
            middle = middle.next;
            mid--;
        }

        middle = ReverseList(middle);
        boolean res = true;
        ListNode curL = middle;
        ListNode curR = head;
        while (curL != null) {
            if (curL.val != curR.val) {
                res = false;
            }
            curR = curR.next;
            curL = curL.next;
        }
        return res;

    }

    // 链表相加
    public ListNode addInList(ListNode head1, ListNode head2) {
        //任意一个链表为空，返回另一个
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //反转两个链表
        head1 = ReverseList(head1);
        head2 = ReverseList(head2);
        //添加表头
        ListNode res = new ListNode(-1);
        ListNode head = res;
        //进位符号
        int carry = 0;
        //只要某个链表还有或者进位还有
        while (head1 != null || head2 != null || carry != 0) {
            //链表不为空则取其值
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;
            //相加
            int temp = val1 + val2 + carry;
            //获取进位
            carry = temp / 10;
            temp %= 10;
            //添加元素
            head.next = new ListNode(temp);
            head = head.next;
            //移动下一个
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        //结果反转回来
        return ReverseList(res.next);
    }

}
