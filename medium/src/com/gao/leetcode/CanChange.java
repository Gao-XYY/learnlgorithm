package com.gao.leetcode;

/**
 * 2337. 移动片段得到字符串
 * 给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中：
 *
 * 字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位 时才能向 右 移动。
 * 字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。
 * 如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。
 */
public class CanChange {

    public static void main(String[] args) {
        String start = "_L__R__R_";
        String target = "L______RR";
        System.out.println(canChange(start, target));
    }

    public static boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n){
            while (i < n && start.charAt(i) == '_'){
                i++;
            }
            while (j < n && target.charAt(j) == '_'){
                j++;
            }
            if (i < n && j < n){
                if (start.charAt(i) != target.charAt(j)){
                    return false;
                }
                char c = start.charAt(i);
                if ((c == 'L' && i < j) || (c == 'R' && i > j)){
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < n){
            if (start.charAt(i) != '_'){
                return false;
            }
            i++;
        }
        while (j < n){
            if (target.charAt(j) != '_'){
                return false;
            }
            j++;
        }
        return true;
    }



}
