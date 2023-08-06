package com.gao.leetcode;

import java.util.Arrays;

/**
 * 2500. 删除每行中的最大值
 * 给你一个 m x n 大小的矩阵 grid ，由若干正整数组成。
 *
 * 执行下述操作，直到 grid 变为空矩阵：
 *
 * 从每一行删除值最大的元素。如果存在多个这样的值，删除其中任何一个。
 * 将删除元素中的最大值与答案相加。
 * 注意 每执行一次操作，矩阵中列的数据就会减 1 。
 *
 * 返回执行上述操作后的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/delete-greatest-value-in-each-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteGreatestValue {

    public static void main(String[] args) {
        Solution008 solution008 = new Solution008();
        int[][] grid = {{1,2,4},{3,3,1}};
        int i = solution008.deleteGreatestValue1(grid);
        System.out.println(i);
    }

}

class Solution008 {
    public int deleteGreatestValue1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++){
            Arrays.sort(grid[i]);
        }
        int res = 0;
        for (int j = 0; j < n; j++){
            int mx = 0;
            for (int i = 0; i < m; i++){
                mx = Math.max(mx, grid[i][j]);
            }
            res += mx;
        }
        return res;
    }

    public int deleteGreatestValue2(int[][] grid) {
        for(int[] i : grid){
            Arrays.sort(i);
        }
        int ans=0;
        for(int j =0;j<grid[0].length;j++){
            ans+=getMax(grid,j);
        }
        return ans;
    }
    public int getMax(int[][] grid,int j){
        int max=0;
        for(int i=0;i<grid.length;i++){
            max=Math.max(max,grid[i][j]);
        }
        return max;
    }

}

