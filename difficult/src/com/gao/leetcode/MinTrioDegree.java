package com.gao.leetcode;

/**
 * 1761. 一个图中连通三元组的最小度数
 * 给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条无向边。
 *
 * 一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。
 *
 * 连通三元组的度数 是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。
 *
 * 请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1 。
 */
public class MinTrioDegree {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{1, 2}, {1, 3}, {3, 2}, {4, 1}, {5, 2}, {3, 6}};
        int i = minTrioDegree(n, edges);
        System.out.println(i);

    }

    public static int minTrioDegree(int n, int[][] edges) {
        int[][] g = new int[n][n];
        int[] degree = new int[n];
        for (int[] edge : edges){
            int x = edge[0] - 1, y = edge[1] - 1;
            g[x][y] = g[y][x] = 1;
            ++degree[x];
            ++degree[y];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i){
            for (int j = i + 1; j < n; ++j){
                if (g[i][j] == 1){
                    for (int k = j + 1; k < n; ++k){
                        if (g[i][k] == 1 && g[j][k] == 1){
                            ans = Math.min(ans, degree[i] + degree[j] + degree[k] - 6);
                        }
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
