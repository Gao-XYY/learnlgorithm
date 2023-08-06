package com.gao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 822. 翻转卡片游戏
 * 在桌子上有 n 张卡片，每张卡片的正面和背面都写着一个正数（正面与背面上的数有可能不一样）。
 *
 * 我们可以先翻转任意张卡片，然后选择其中一张卡片。
 *
 * 如果选中的那张卡片背面的数字 x 与任意一张卡片的正面的数字都不同，那么这个数字是我们想要的数字。
 *
 * 哪个数是这些想要的数字中最小的数（找到这些数中的最小值）呢？如果没有一个数字符合要求的，输出 0 。
 *
 * 其中, fronts[i] 和 backs[i] 分别代表第 i 张卡片的正面和背面的数字。
 *
 * 如果我们通过翻转卡片来交换正面与背面上的数，那么当初在正面的数就变成背面的数，背面的数就变成正面的数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/card-flipping-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Flipgame {

    public static void main(String[] args) {

    }

}

class Solution007 {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> same = new HashSet<>();
        for (int i = 0; i < fronts.length; i++){
            if (fronts[i] == backs[i]){
                same.add(fronts[i]);
            }
        }
        int res = 3000;
        for (int x : fronts){
            if (x < res && !same.contains(x)){
                res = x;
            }
        }
        for (int x : backs){
            if (x < res && !same.contains(x)){
                res = x;
            }
        }
        return res % 3000;

    }
}
