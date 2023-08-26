package com.gao.leetcode;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] nums = new int[n + m];
        if (m == 0){
            if (n % 2 == 0){
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }

        if (n == 0){
            if (m % 2 == 0){
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0, i = 0, j = 0;
        while (count != (m + n)){
            if (i == m){
                while (j != n){
                    nums[count++] = nums2[j++];
                }
                break;
            }

            if (j == n){
                while (i != m){
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]){
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }
        if (count % 2 == 0){
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }

    }
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int len = n + m;
        int left = -1, right = -1, nums1Start = 0, nums2Start = 0;
        for (int i = 0; i <= len / 2; i++){
            left = right;
            if (nums1Start < m && (nums2Start >= n || nums1[nums1Start] < nums2[nums2Start])){
                right = nums1[nums1Start++];
            } else {
                right = nums2[nums2Start++];
            }
        }
        if ((len & 1) == 0){
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

}
