package com.gao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountServers {

    public static void main(String[] args) {
        int[][] grind = {{1,0}, {0,1}};
        int i = countServers(grind);
        System.out.println(i);
    }

    public static int countServers1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (grid[i][j] == 1){
                    rows.put(i, rows.getOrDefault(i, 0) + 1);
                    cols.put(j, rows.getOrDefault(j, 0) + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (grid[i][j] == 1 && (rows.get(i) > 1 || cols.get(j) > 1)){
                    ++ans;
                }
            }
        }
        return ans;

    }

    public static int countServers(int[][] grid){
        int m = grid.length, n = grid[0].length;
        Map<Integer, Integer> rows = new HashMap<Integer, Integer>();
        Map<Integer, Integer> cols = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    rows.put(i, rows.getOrDefault(i, 0) + 1);
                    cols.put(j, cols.getOrDefault(j, 0) + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && (rows.get(i) > 1 || cols.get(j) > 1)) {
                    ++ans;
                }
            }
        }
        return ans;

    }

}
