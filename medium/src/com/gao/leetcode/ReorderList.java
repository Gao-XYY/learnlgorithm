package com.gao.leetcode;

import java.util.ArrayList;

public class ReorderList {
}

class ListNode02 {
    int val;
    ListNode02 next;

    ListNode02() {
    }

    ListNode02(int val) {
        this.val = val;
    }

    ListNode02(int val, ListNode02 next) {
        this.val = val;
        this.next = next;
    }
}

class Solution006 {
    public void reorderList(ListNode02 head) {
        if (head == null){
            return;
        }
        ArrayList<ListNode02> list = new ArrayList<>();
        ListNode02 node = head;
        while (node != null){
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j){
            list.get(i).next = list.get(j);
            i++;
            if (i == j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    //=======================================================================
    ListNode cur, prev;
    public void reorderList(ListNode head) {
        reorderList(head, head);
    }
    public void reorderList(ListNode slow, ListNode fast) {
        if (fast == null) { //处理链表长度为偶数的情况
            cur = slow; //需要插入的第一个节点的前一个节点
            prev = null;
            return;
        }
        if (fast.next == null) { //处理链表长度为奇数的情况
            cur = slow.next; //需要插入的第一个节点
            slow.next = null;
            prev = slow; //重排后的最后一个节点
            return;
        }
        reorderList(slow.next, fast.next.next);
        ListNode next = cur.next;
        //节点交换
        slow.next = cur;
        cur.next = prev;
        prev = slow;
        cur = next;
    }

}
