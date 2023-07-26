package com.gao.leetcode;



/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {

    public static void main(String[] args) {

    }

}
class Solution003 {
    public int trap1(int[] height) {
        int sum = 0;
        int max = getMax(height);
        for (int i = 1; i <= max; i++){
            boolean isStart = false;
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++){
                if (isStart && height[j] < i){
                    temp_sum++;
                }
                if (height[j] >= i){
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    private int getMax(int[] height){
        int max = 0;
        for (int i = 0; i < height.length; i++){
            if (height[i] > max){
                max = height[i];
            }
        }
        return max;
    }

    public int trap2(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }


}