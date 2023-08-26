package com.gao.leetcode;

/**
 * 849. 到最近的人的最大距离
 * 给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
 *
 * 至少有一个空座位，且至少有一人已经坐在座位上。
 *
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 *
 * 返回他到离他最近的人的最大距离。
 */
public class MaxDistToClosest {

    public static void main(String[] args) {
        int[] seats = {1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] seats) {
        int res = 0, l = 0;
        while (l < seats.length && seats[l] == 0){
            ++l;
        }
        res = Math.max(res, l);
        while (l < seats.length){
            int r = l + 1;
            while (r < seats.length && seats[r] == 0){
                ++r;
            }
            if (r == seats.length){
                res = Math.max(res, r - l - 1);
            } else {
                res = Math.max(res, (r - l) / 2);
            }
            l = r;
        }
        return res;
    }

}
