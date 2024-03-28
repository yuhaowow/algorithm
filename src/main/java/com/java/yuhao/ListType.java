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


}
