package com.gao.hw;

import java.util.Scanner;

/**
 * HJ2 计算某字符出现次数
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * 数据范围：1 ≤ n ≤ 1000
 * 输入描述：
 * 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 */
public class CountCharAristFrequencyHJ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();//接收第一次的字符串
        String s2 = in.nextLine();//接收单独的字母
        String s = s1.toUpperCase().replaceAll(s2.toUpperCase(), "");//将s1中的字母转换成大写的，然后用replaceAll将s2中的字母转换成空
        System.out.println(s1.length() - s.length());


    }
}
