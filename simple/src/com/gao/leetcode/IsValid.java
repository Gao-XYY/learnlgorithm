package com.gao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的括号有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class IsValid {
    public static void main(String[] args) {

    }
}

class Solution005 {
    public boolean isValid(String s) {
        int n = s.length();
        int[] stack = new int[n];
        int idx = -1;//栈顶索引
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                stack[++idx] = c;
            }else {
                if (idx != -1 && stack[idx] == map.get(c)){
                    --idx;
                }else {
                    return false;
                }
            }
        }
        return idx == -1;
    }
}
