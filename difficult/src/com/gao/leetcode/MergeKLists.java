package com.gao.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKLists {

    public static void main(String[] args) {

    }

}

class Solution009 {
    public ListNode01 mergeKLists(ListNode01[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode01> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode01>() {
            @Override
            public int compare(ListNode01 o1, ListNode01 o2){
                if (o1.val < o2.val){
                    return -1;
                } else if (o1.val == o2.val){
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        ListNode01 dummy = new ListNode01(0);
        ListNode01 p = dummy;
        for (ListNode01 node : lists){
            if (node != null){
                queue.add(node);
            }
        }
        while (!queue.isEmpty()){
            p.next = queue.poll();
            p = p.next;
            if (p.next != null){
                queue.add(p.next);
            }
        }
        return dummy.next;
    }
}

class ListNode01 {
    int val;
    ListNode01 next;
    ListNode01() {}
    ListNode01(int val) { this.val = val; }
    ListNode01(int val, ListNode01 next) { this.val = val; this.next = next; }
}