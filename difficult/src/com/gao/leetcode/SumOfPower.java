package com.gao.leetcode;

import java.util.Arrays;

/**
 * 2681. 英雄的力量
 * 给你一个下标从 0 开始的整数数组 nums ，它表示英雄的能力值。如果我们选出一部分英雄，这组英雄的 力量定义为：
 *
 * i0 ，i1，... ik 表示这组英雄在数组中的下标。那么这组英雄的力量为 max(nums[i0],nums[i1] ... nums[ik])2 * min(nums[i0],nums[i1] ... nums[ik]) 。
 * 请你返回所有可能的 非空 英雄组的 力量 之和。由于答案可能非常大，请你将结果对 109 + 7取余。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/power-of-heroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumOfPower {

    public static void main(String[] args) {

    }

}

class Solution006 {
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int dp = 0, preSum = 0;
        int res = 0, mod = 1000000007;
        for (int i = 0; i < nums.length; i++){
            dp = (nums[i] + preSum) % mod;
            preSum = (preSum + dp) % mod;
            res = (int) ((res + (long) nums[i] * nums[i] % mod * dp) % mod);
            if (res < 0){
                res += mod;
            }
        }
        return res;
    }
}
