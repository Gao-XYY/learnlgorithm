package com.gao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 模拟行走机器人
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 */
public class RobotSim {

    public static void main(String[] args) {
        int[] commands = {4,-1,4,-2,4};

        int[][] obstacles ={{2,4}};

        Solution002 solution002 = new Solution002();
        int i = solution002.robotSim(commands, obstacles);
        System.out.println(i);

    }

}

class Solution002 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int px = 0, py = 0, d = 1;
        Set<Integer> set = new HashSet<>();
        for (int[] obstacle : obstacles){
            set.add(obstacle[0] * 60001 + obstacle[1]);
        }
        int res = 0;
        for (int c : commands){
            if (c < 0){
                d += c == -1 ? 1 : -1;
                d %= 4;
                if (d < 0){d += 4;}
            }else {
                for (int i = 0; i < c; i++){
                    if (set.contains((px + dirs[d][0]) * 60001 + py + dirs[d][1])){
                        break;
                    }
                    px += dirs[d][0];
                    py += dirs[d][1];
                    res = Math.max(res, px * px + py * py);
                }
            }
        }
        return res;
    }
}
