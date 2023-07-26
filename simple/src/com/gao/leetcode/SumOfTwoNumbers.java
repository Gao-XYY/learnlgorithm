package com.gao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */
public class SumOfTwoNumbers {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,8,11,9,12,13};
        int target = 25;
        Solution001 solution1 = new Solution001();
//        int[] ints = solution1.twoSum1(nums, target);
        int[] ints = solution1.twoSum2(nums, target);
        for (int i = 0; i <= ints.length - 1; i++){
            System.out.println(ints[i]);
        }


    }

}

class Solution001 {
    public int[] twoSum1(int[] nums, int target) {

        for (int i = 0; i <= nums.length - 1; i++){
            for (int j = i + 1; j <= nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];

    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }



}

