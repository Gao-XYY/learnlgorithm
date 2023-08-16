package com.gao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution013 solution = new Solution013();
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);

    }
}

class Solution013 {
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> characters = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i){
            if (i != 0){
                // 左指针向右移动一格，移除一个字符
                characters.remove(s.charAt(i -1));
            }
            while (rk + 1 < n && !characters.contains(s.charAt(rk + 1))){
                // 不断地移动右指针
                characters.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);

        }
        return ans;

    }
}