package com.gao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *
 */
public class RomanNumeralsToInteger {

    public static void main(String[] args) {
        Solution003 solution3 = new Solution003();
        String s = "III";
        solution3.romanToInt(s);
    }

}

class Solution003 {

    Map<Character, Integer> map = new HashMap<Character, Integer>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };
    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++){
            int value = map.get(s.charAt(i));
            if (i < n -1 && value < map.get(s.charAt(i + 1))){
                ans -= value;
            }else {
                ans += value;
            }

        }
        return ans;
    }
}