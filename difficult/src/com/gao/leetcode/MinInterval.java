package com.gao.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 包含每个查询的最小区间
 * 给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示第 i 个区间开始于 lefti 、结束于 righti（包含两侧取值，闭区间）。区间的 长度 定义为区间中包含的整数数目，更正式地表达是 righti - lefti + 1 。
 * 再给你一个整数数组 queries 。第 j 个查询的答案是满足 lefti <= queries[j] <= righti 的 长度最小区间 i 的长度 。如果不存在这样的区间，那么答案是 -1 。
 * 以数组形式返回对应查询的所有答案。
 */
public class MinInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,4},{3,6},{4,4}};
        int[] queries = {2,3,4,5};
        Solution001 solution001 = new Solution001();
        int[] ints = solution001.minInterval1(intervals, queries);
        for (int i = 0; i < ints.length; i++){
            System.out.println(ints[i]);
        }
    }

}

class Solution001 {
    public int[] minInterval1(int[][] intervals, int[] queries) {

        Integer[] qindex = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++){
            qindex[i] = i;
        }
        Arrays.sort(qindex, (i,j) -> queries[i] - queries[j]);
        Arrays.sort(intervals, (i,j) -> i[0] - j[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        int i = 0;
        for (int qi : qindex){
            while (i < intervals.length && intervals[i][0] <= queries[qi]) {
                pq.offer(new int[] {intervals[i][1] - intervals[i][0] + 1, intervals[i][0], intervals[i][1]});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[2] < queries[qi]){
                pq.poll();
            }
            if (!pq.isEmpty()) {
                res[qi] = pq.peek()[0];
            }
        }

        return res;
    }

    public int[] minInterval2(int[][] intervals, int[] queries) {
        int n = intervals.length, m = queries.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] qs = new int[m][0];
        for (int i = 0; i < m; i++){
            qs[i] = new int[]{queries[i],i};
        }
        Arrays.sort(qs, (a,b) -> a[0] -b[0]);
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;
        for (int[] q : qs){
            while (i < n && intervals[i][0] <= q[0]){
                int a = intervals[i][0], b = intervals[i][1];
                pq.offer(new int[] {b - a + 1, b});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < q[0]){
                pq.poll();
            }
            if (!pq.isEmpty()){
                ans[q[1]] = pq.peek()[0];
            }
        }
        return ans;
    }

    public int[] minInterval3(int[][] intervals, int[] queries) {
        int m = intervals.length;
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);  // 对区间根据左边界做升序排序
        int n = queries.length;
        int[][] qs = new int[n][2];             // 为了对查询值进行升序排序，重构查询数组，记录每个查询值原来的索引
        for(int i = 0; i < n; i++){
            qs[i] = new int[]{queries[i], i};
        }
        Arrays.sort(qs, (a1, a2) -> a1[0] - a2[0]);     // 对重构的查询值数组进行排序
        Queue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[0] - a2[0]);   // 对备选区间根据区间长度构建小顶堆，队列中的元素是一个二元数组[区间长度, 区间右边界]
        int[] ans = new int[n];     // 结果数组
        int i = 0;  // 搜索区间的指针
        for(int j = 0; j < n; j++){
            // 将所有左边界小于等于当前查询值的区间加入队列，相当于满足一半的条件：lefti <= queries[j]
            while(i < m && qs[j][0] >= intervals[i][0]){
                pq.offer(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i++;
            }
            // 将所有右边界小于当前查询值得区间弹出队列，相当于不满足另一半条件：queries[j] <= righti
            while(!pq.isEmpty() && pq.peek()[1] < qs[j][0]){
                pq.poll();
            }
            // 队首区间即为满足条件且长度最小的区间；如果队列为空，说明不存在满足条件的区间；注意查询值原来的索引存储在qs[j][1]
            ans[qs[j][1]] = pq.isEmpty() ? -1 : pq.peek()[0];
        }
        return ans;
    }


}