package com.gao.leetcode;

/**
 * 1289. 下降路径最小和 II
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 *
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 */
public class MinFallingPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1,2,3}, {4,5,6}, {7,8,9}};
        Solution008 solution = new Solution008();
        int i = solution.minFallingPathSum(grid);
        System.out.println(i);
    }

}

class Solution008 {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++){
            d[0][i] = grid[0][i];
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    if (j == k){
                        continue;
                    }
                    d[i][j] = Math.min(d[i][j], d[i - 1][k] + grid[i][j]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++){
            res = Math.min(res, d[n - 1][j]);
        }
        return res;

    }
}
