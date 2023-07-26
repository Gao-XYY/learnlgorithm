package com.gao.leetcode;

import java.util.PriorityQueue;

/**
 * 满足不等式的最大值
 * 给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] = [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。
 * 请你找出 yi + yj + |xi - xj| 的 最大值，其中 |xi - xj| <= k 且 1 <= i < j <= points.length。
 * 题目测试数据保证至少存在一对能够满足 |xi - xj| <= k 的点。
 */
public class FindMaxValueOfEquation {
    public static void main(String[] args) {
        Solution002 solution002 = new Solution002();
        int[][] points = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        int k = 1;
        int value = solution002.findMaxValueOfEquation(points, k);
        System.out.println(value);
    }
}

class Solution002 {
    public int findMaxValueOfEquation(int[][] points, int k) {

        int res = Integer.MIN_VALUE;
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (int[] point : points){
            int x = point[0], y = point[1];
            while (!heap.isEmpty() && x - heap.peek()[1] > k){
                heap.poll();
            }
            if (!heap.isEmpty()){
                res = Math.max(res, x + y - heap.peek()[0]);
            }
            heap.offer(new int[]{ x - y, x});
        }
        return res;
    }
}

