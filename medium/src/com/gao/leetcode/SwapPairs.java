package com.gao.leetcode;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode003 node = new ListNode003(1);
        node.next = new ListNode003(2);
        node.next.next = new ListNode003(3);
        node.next.next.next = new ListNode003(4);
        Solution009 solution = new Solution009();
        ListNode003 listNode003 = solution.swapPairs(node);


    }

}

class Solution009 {
    public ListNode003 swapPairs(ListNode003 head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode003 newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}

class ListNode003 {
    int val;
    ListNode003 next;
    ListNode003() {}
    ListNode003(int val) { this.val = val; }
    ListNode003(int val, ListNode003 next) { this.val = val; this.next = next; }
}
