package com.gao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> list = summaryRanges(nums);
        for(String l : list){
            System.out.println(l);
        }
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        int i = 0, n = nums.length;
        while (i < n){
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1){
                i ++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
