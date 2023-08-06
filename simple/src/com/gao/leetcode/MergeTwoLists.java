package com.gao.leetcode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {

    public static void main(String[] args) {

    }

}

class Solution010 {
    public ListNode01 mergeTwoLists(ListNode01 list1, ListNode01 list2) {
        if (list1 == null){
            return list2;
        } else if (list2 == null){
            return list1;
        } else if (list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }
}

class ListNode01 {
    int val;
    ListNode01 next;
    ListNode01() {}
    ListNode01(int val) { this.val = val; }
    ListNode01(int val, ListNode01 next) { this.val = val; this.next = next; }
}
