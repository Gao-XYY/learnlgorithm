package com.gao.hw;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 *
 *
 * 提示:
 * 0 <= index <= 11111111
 * 1 <= value <= 100000
 *
 * 输入描述：
 * 先输入键值对的个数n（1 <= n <= 500）
 * 接下来n行每行输入成对的index和value值，以空格隔开
 *
 * 输出描述：
 * 输出合并后的键值对（多行）
 */
public class MergingTableRecordsHJ8 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int next = in.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < next; i++){
                int key = in.nextInt();
                int value = in.nextInt();
                if (map.containsKey(key)){
                    map.put(key, map.get(key) + value);
                } else {
                    map.put(key,value);
                }
            }
            for (Map.Entry<Integer,Integer> integerIntegerEntry : map.entrySet()){
                System.out.println(integerIntegerEntry.getKey() + " " + integerIntegerEntry.getValue());
            }
        }

    }
}
