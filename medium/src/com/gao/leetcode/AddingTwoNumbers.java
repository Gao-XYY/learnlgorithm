package com.gao.leetcode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 */
public class AddingTwoNumbers {
    public static void main(String[] args) {

    }
}

class Solution001 {
    public class ListNode {
        int val; //当前节点
        ListNode next; //next 指向下一个链表节点
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); //哨兵节点
        ListNode cur = dummy;
        int carry = 0; //进位
        while (l1 != null || l2 != null || carry != 0){ //有一个不是空节点，或者还有进位，就继续迭代
            if (l1 != null) carry += l1.val; //节点值和进位值加到一起
            if (l2 != null) carry += l2.val; //节点值和进位值加到一起
            cur = cur.next = new ListNode(carry % 10); //每个节点保存一个数位
            carry /= 10; //新的进位
            if (l1 != null) l1 = l1.next; //下一个节点
            if (l2 != null) l2 = l2.next; //下一个节点

        }
        return dummy.next; //哨兵节点的下一个节点就到头节点
    }
}
