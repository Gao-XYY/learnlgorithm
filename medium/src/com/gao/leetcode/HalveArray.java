package com.gao.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 2208. 将数组和减半的最少操作次数
 * 给你一个正整数数组 nums 。每一次操作中，你可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半。（注意，在后续操作中你可以对减半过的数继续执行操作）
 *
 * 请你返回将 nums 数组和 至少 减少一半的 最少 操作数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-operations-to-halve-array-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HalveArray {

    public static void main(String[] args) {
        Solution004 solution004 = new Solution004();
        int[] nums = {5,19,8,1};
        System.out.println(solution004.halveArray2(nums));

    }

}

class Solution004 {
    public int halveArray1(int[] nums) {
        PriorityQueue<Double> doubles = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int num : nums){
            doubles.offer((double)num);
        }
        int res = 0;
        double sum = 0;
        for (int num : nums){
            sum += sum;
        }
        double sum2 = 0.0;
        while (sum2 < sum / 2){
            double x = doubles.poll();
            sum2 += x / 2;
            doubles.offer(x / 2);
            res++;
        }
        return res;
    }

    public int halveArray2(int[] nums) {
        int len = nums.length;
        List<Double> list = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i< len;i++){
            sum += nums[i];
            list.add(Double.valueOf(nums[i]));
        }
        Collections.sort(list, Collections.reverseOrder());
        double half = sum /2;
        int result = 0;
        int index = 0;
        while (sum > half){
            result++;
            double h = list.get(index)/2;
            sum -= h;
            list.set(index, h);
            if (index < list.size() -1 && list.get(index) < list.get(index+1))
                index++;

            if (index < list.size() -1 && list.get(0) > list.get(index)){
                index = 0;
                Collections.sort(list, Collections.reverseOrder());
            }
        }
        return result;
    }

}
