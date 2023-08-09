package com.gao.leetcode;

/**
 * 1281. 整数的各位积和之差
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 */
public class SubtractProductAndSum {

    public static void main(String[] args) {
        Solution012 solution = new Solution012();
        int i = solution.subtractProductAndSum(234);
        System.out.println(i);
    }

}

class Solution012 {
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n != 0){
            int mod = n % 10;
            n /= 10;
            product *= mod;
            sum += mod;
        }
        return product - sum;
    }
}

