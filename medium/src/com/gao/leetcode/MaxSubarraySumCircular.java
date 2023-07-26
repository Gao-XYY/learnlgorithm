package com.gao.leetcode;

/**
 * 环形子数组的最大和
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 */
public class MaxSubarraySumCircular {
}

class Solution003 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        //对坐标为 0 处的元素单独处理，避免考虑子数组为空的情况
        leftMax[0] = nums[0];
        int leftSum = nums[0];
        int pre = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++){
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(res, pre);
            leftSum += nums[i];
            leftMax[i] = Math.max(leftMax[i - 1], leftSum);
        }

        //从右到左枚举后缀，固定后缀，选择最大前缀
        int rightSum = 0;
        for (int i = n - 1; i > 0; i--){
            rightSum += nums[i];
            res = Math.max(res, rightSum + leftMax[i - 1]);
        }

        return res ;
    }

    public int maxSubarraySumCircular1(int[] nums){
        int maxS = Integer.MIN_VALUE; //最大子数组和，不能为空
        int minS = 0; //最小子数组和， 可以为空
        int maxF = 0, minF = 0, sum = 0;
        for (int x : nums){
            //以nums[i-1] 结尾的子数组选或不选(取max) + x = 以x结尾的最大子数组和
            maxF = Math.max(maxF, 0) + x;
            maxS = Math.max(maxS, maxF);
            //以nums[i-1] 结尾的子数组选或不选(取min) + x = 以x结尾的最小子数组和
            minF = Math.min(minF, 0) + x;
            minS = Math.min(minS, minF);
            sum += x;
        }
        return sum == minS ? maxS : Math.max(maxS, sum - minS);
    }


}