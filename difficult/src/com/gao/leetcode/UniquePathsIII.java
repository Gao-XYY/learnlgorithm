package com.gao.leetcode;

public class UniquePathsIII {

    public static void main(String[] args) {

    }

}

class Solution007 {
    public int uniquePathsIII(int[][] grid) {
        int cnt0 = 0, sx = -1, sy = -1;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 1){
                    cnt0++;
                } else if (grid[i][j] == 1){
                    sx = i;
                    sy = j;
                }
            }
        }
        return dfs(grid, sx, sy, cnt0 + 1);
    }

    private int dfs(int[][] grid, int x, int y, int left){
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] < 0){
            return 0;
        }
        if (grid[x][y] == 2){
            return left == 0 ? 1 : 0;
        }
        grid[x][y] = -1;
        int ans = dfs(grid, x -1, y, left - 1) + dfs(grid, x, y - 1, left - 1) + dfs(grid, x + 1, y, left - 1) + + dfs(grid, x , y + 1, left - 1);
        grid[x][y] = 0;
        return ans;
    }

}
