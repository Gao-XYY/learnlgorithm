package com.gao.leetcode;

/**
 * 813. 最大平均值和的分组
 * 给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成。
 *
 * 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。
 *
 * 返回我们所能得到的最大 分数 是多少。答案误差在 10-6 内被视为是正确的。
 */
public class LargestSumOfAverages {

    public static void main(String[] args) {

        int[] nums = {9,1,2,3,9};
        int k = 3;
        Solution012 solution = new Solution012();
        double v = solution.largestSumOfAverages(nums, k);
        System.out.println(v);

    }

}

class Solution012 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }
        double[] dp = new double[n + 1];
        for (int i = 1; i <= n; i++){
            dp[i]= prefix[i] / i;
        }
        for (int j = 2; j <= k; j++){
            for (int i = n; i >= j; i--){
                for (int x = j - 1; x < i; x++){
                    dp[i] = Math.max(dp[i], dp[x] + (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[n];
    }
}
