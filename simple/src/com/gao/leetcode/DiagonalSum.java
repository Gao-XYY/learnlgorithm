package com.gao.leetcode;

/**
 * 1572. 矩阵对角线元素的和
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 */
public class DiagonalSum {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        Solution013 solution = new Solution013();
        int i = solution.diagonalSum(mat);
        System.out.println(i);
    }
}

class Solution013 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0;
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < n; ++j){
                if (i == j || i + j == n - 1){
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }
}
