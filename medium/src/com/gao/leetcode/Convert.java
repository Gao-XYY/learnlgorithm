package com.gao.leetcode;

/**
 * 6. N 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 */
public class Convert {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        String convert = convert(s, numRows);
        System.out.println(convert);
        //PAHNAPLSIIGYIR
        //PAHNAPLSIIGYIR

    }

    public static String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n){
            return s;
        }

        int t = numRows * 2 - 2;
        int c = (n + t - 1) / t * (numRows -1);
        char[][] mat = new char[numRows][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i){
            mat[x][y] = s.charAt(i);
            if (i % t < numRows - 1){
                ++x; //向下移动
            } else {
                --x;
                ++y; //向上移动
            }
        }

        StringBuffer ans = new StringBuffer();
        for (char[] row : mat){
            for (char ch : row){
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();


    }

}
