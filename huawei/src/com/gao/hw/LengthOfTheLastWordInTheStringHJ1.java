package com.gao.hw;

import java.util.Scanner;

/** HJ1 字符串最后一个单词的长度
 * 字符串最后一个单词的长度
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 */
public class LengthOfTheLastWordInTheStringHJ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String world = in.nextLine();
        int index = world.lastIndexOf(" ");
        if (index < 0){
            System.out.println(world.length());
            return;
        }
        String w = world.substring(index + 1);
        System.out.println(w.length());

    }
}
