package com.gao.leetcode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 */
public class AddingTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        Solution001 solution = new Solution001();
        solution.addTwoNumbers(node1,node2);
    }
}

class ListNode001 {
    int val; //当前节点
    ListNode001 next; //next 指向下一个链表节点
    ListNode001() {}
    ListNode001(int val) {this.val = val;}
    ListNode001(int val, ListNode001 next) {
        this.val = val;
        this.next = next;
    }
}

class Solution001 {

    public ListNode001 addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode001 dummy = new ListNode001(); //哨兵节点
        ListNode001 cur = dummy;
        int carry = 0; //进位
        while (l1 != null || l2 != null || carry != 0){ //有一个不是空节点，或者还有进位，就继续迭代
            if (l1 != null) carry += l1.val; //节点值和进位值加到一起
            if (l2 != null) carry += l2.val; //节点值和进位值加到一起
            cur = cur.next = new ListNode001(carry % 10); //每个节点保存一个数位
            carry /= 10; //新的进位
            if (l1 != null) l1 = l1.next; //下一个节点
            if (l2 != null) l2 = l2.next; //下一个节点

        }
        return dummy.next; //哨兵节点的下一个节点就到头节点
    }
}
