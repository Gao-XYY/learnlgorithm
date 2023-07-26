package com.gao.leetcode;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

    }
}

class Solution004 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++){
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2){
        int length = Math.min(str1.length(),str2.length());
        int index = 0; //标志位
        while (index < length && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0, index);//截取0-index位置的字符串
    }


}