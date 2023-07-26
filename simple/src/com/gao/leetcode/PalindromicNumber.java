package com.gao.leetcode;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class PalindromicNumber {

    public static void main(String[] args) {
        Solution002 solution2 = new Solution002();
//        solution3.isPalindrome(5);
        boolean palindrome = solution2.isPalindrome(121);
        System.out.println(palindrome);
    }

}

class Solution002 {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int cur = 0;
        int num = x;
        while (num != 0){
            cur = cur * 10 + num % 10;
            System.out.println("=========" + cur);
            num /= 10;
            System.out.println(num);
            System.out.println(cur);
        }
        return cur == x;
    }
}