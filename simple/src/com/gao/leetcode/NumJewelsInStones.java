package com.gao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. 宝石与石头
 * 给你一个字符串 jewels代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。stones中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumJewelsInStones {
    public static void main(String[] args) {
        Solution007 solution007 = new Solution007();
        String jewels = "aA", stones = "aAAbbbb";
        int Count = solution007.numJewelsInStones3(jewels, stones);
        System.out.println(Count);

    }
}

class Solution007 {
    public int numJewelsInStones1(String jewels, String stones) {
        int jewelsCount = 0;
        int jewelsLength = jewels.length(), stonesLength = stones.length();
        for (int i = 0; i < stonesLength; i++){
            char stone = stones.charAt(i);
            for (int j = 0; j < jewelsLength; j++){
                char jewel = jewels.charAt(j);
                if (stone == jewel){
                    jewelsCount++;
                    break;
                }
            }
        }
        return jewelsCount;
    }

    public int numJewelsInStones2(String jewels, String stones) {
        int jewelsCount = 0;
        Set<Character> jewelsSet = new HashSet<>();
        int jewelsLength = jewels.length(), stonesLength = stones.length();
        for (int i = 0; i < jewelsLength; i++){
            char jewel = jewels.charAt(i);
            jewelsSet.add(jewel);
        }
        for (int i = 0; i < stonesLength; i++){
            char stone = stones.charAt(i);
            if (jewelsSet.contains(stone)){
                jewelsCount++;
            }
        }
        return jewelsCount;
    }

    public int numJewelsInStones3(String jewels, String stones) {
        //把jewels 转换成字符集合 mask
        long mask = 0;
        for (char c : jewels.toCharArray()){
            mask |= 1L << (c & 63);
        }
        //统计有多少 stones[i] 在集合 mask 中
        int ans = 0;
        for (char c : stones.toCharArray()){
            ans += mask >> (c & 63) & 1;
        }
        return ans;
    }

}
