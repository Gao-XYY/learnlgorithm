package com.gao.leetcode;

import java.util.*;

public class MiniNumTime {
}

class Solution005 {
    public int minimumTime1(int n, int[][] relations, int[] time) {
        int mx = 0;
        List<Integer>[] prev = new List[n + 1];
        for (int i = 0; i <= 0; i++){
            prev[i] = new ArrayList<Integer>();
        }
        for (int[] relation : relations){
            int x = relation[0], y = relation[1];
            prev[y].add(x);
        }
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 1; i <= n; i++){
            mx = Math.max(mx, dp(i, time, prev, memo));
        }
        return mx;
    }

    public int dp(int i, int[] time, List<Integer>[] prev, Map<Integer,Integer> memo){
        if (!memo.containsKey(i)){
            int cur = 0;
            for (int p : prev[i]){
                cur = Math.max(cur, dp(p, time, prev, memo));
            }
            cur += time[i - 1];
            memo.put(i, cur);
        }
        return memo.get(i);
    }


    public int minimumTime2(int n, int[][] relations, int[] time) {
        int[] dp = new int[n + 1];
        int[] inDegree = new int[n + 1];
        int[] last = new int[n + 1];
        int edgeCount = relations.length;
        int[] pre = new int[edgeCount + 1];
        // 初始化last为-1
        Arrays.fill(last, -1);
        for (int i = 0; i < edgeCount; i++) {
            int v0 = relations[i][0];
            int v1 = relations[i][1];
            ++inDegree[v1];
            // 建图
            pre[i] = last[v0];
            last[v0] = i;
        }
        int[] queue = new int[(int) Math.min(n * (n + 1L) / 2, 5L * 10_000)];
        int queueFront = 0;
        int queueTail = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                res = Math.max(res, time[i - 1]);
                dp[i] = time[i - 1];
                queue[queueTail++] = i;
            }
        }
        while (queueFront < queueTail) {
            int size = queueTail - queueFront;
            for (int i = 0; i < size; i++) {
                int front = queue[queueFront++];
                res = Math.max(res, dp[front]);
                // 遍历所有边
                for (int lastEdge = last[front]; lastEdge != -1; lastEdge = pre[lastEdge]) {
                    int v = relations[lastEdge][1];
                    dp[v] = Math.max(dp[v], dp[front] + time[v - 1]);
                    if (--inDegree[v] == 0) {
                        queue[queueTail++] = v;
                    }
                }
            }
        }
        return res;
    }

}
