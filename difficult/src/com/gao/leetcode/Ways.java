package com.gao.leetcode;

/**
 *1444. 切披萨的方案数
 * 给你一个 rows x cols 大小的矩形披萨和一个整数 k ，矩形包含两种字符： 'A' （表示苹果）和 '.' （表示空白格子）。你需要切披萨 k-1 次，得到 k 块披萨并送给别人。
 *
 * 切披萨的每一刀，先要选择是向垂直还是水平方向切，再在矩形的边界上选一个切的位置，将披萨一分为二。如果垂直地切披萨，那么需要把左边的部分送给一个人，如果水平地切，那么需要把上面的部分送给一个人。在切完最后一刀后，需要把剩下来的一块送给最后一个人。
 *
 * 请你返回确保每一块披萨包含 至少 一个苹果的切披萨方案数。由于答案可能是个很大的数字，请你返回它对 10^9 + 7 取余的结果。
 * pizza = ["A..","AAA","..."], k = 3
 */
public class Ways {

    public static void main(String[] args) {
        String[] pizza = {"A..", "AAA", "..."};
        String[] pizz = {"A..", "AA.", "..."};
        int k = 3;
        int ways = ways(pizz, k);
        System.out.println(ways);
    }

    public static int ways(String[] pizza, int k) {
       int m = pizza.length, n = pizza[0].length(), mod = 1_000_000_007;
       int[][] apples = new int[m + 1][n + 1];
       int[][][] dp = new int[k + 1][m + 1][n + 1];

       for (int i = m - 1; i >= 0; i--){
           for (int j = n - 1; j >= 0; j--){
               apples[i][j] = apples[i][j + 1] + apples[i + 1][j] - apples[i + 1][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
               dp[1][i][j] = apples[i][j] > 0 ? 1 : 0;
           }
       }

       for (int ki = 2; ki <= k; ki++){
           for (int i = 0; i < m; i++){
               for (int j = 0; j < n; j++){
                   for (int l = i + 1; l < m; l++){
                       if (apples[i][j] > apples[l][j]){
                           dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][l][j]) % mod;
                       }
                   }

                   for (int h = j + 1; h < n; h++){
                       if (apples[i][j] > apples[i][h]){
                           dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][i][h]) % mod;
                       }
                   }

               }
           }
       }
       return dp[k][0][0];
    }

}
