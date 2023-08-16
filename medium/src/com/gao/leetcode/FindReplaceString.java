package com.gao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 833. 字符串中的查找与替换
 * 你会得到一个字符串 s (索引从 0 开始)，你必须对它执行 k 个替换操作。替换操作以三个长度均为 k 的并行数组给出：indices, sources,  targets。
 *
 * 要完成第 i 个替换操作:
 *
 * 检查 子字符串  sources[i] 是否出现在 原字符串 s 的索引 indices[i] 处。
 * 如果没有出现， 什么也不做 。
 * 如果出现，则用 targets[i] 替换 该子字符串。
 * 例如，如果 s = "abcd" ， indices[i] = 0 , sources[i] = "ab"， targets[i] = "eee" ，那么替换的结果将是 "eeecd" 。
 *
 * 所有替换操作必须 同时 发生，这意味着替换操作不应该影响彼此的索引。测试用例保证元素间不会重叠 。
 *
 * 例如，一个 s = "abc" ，  indices = [0,1] ， sources = ["ab"，"bc"] 的测试用例将不会生成，因为 "ab" 和 "bc" 替换重叠。
 * 在对 s 执行所有替换操作后返回 结果字符串 。
 *
 * 子字符串 是字符串中连续的字符序列。
 * s = "abcd", indices = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 */
public class FindReplaceString {

    public static void main(String[] args) {
        String s = "abcd";
        int[] indices = {0,2};
        String[] sources = {"ab", "ec"};
        String[] targest = {"eee", "ffff"};
        Solution011 solution = new Solution011();
        String replaceString = solution.findReplaceString(s, indices, sources, targest);
        System.out.println(replaceString);
    }

}

class Solution011 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        int n = s.length(), m = indices.length;

        List<Integer> ops = new ArrayList<>();
        for (int i = 0; i < m; i++){
            ops.add(i);
        }
        ops.sort((i, j) -> indices[i] - indices[j]);

        StringBuilder ans = new StringBuilder();
        int pt = 0;
        for (int i = 0; i < n; ){
            while (pt < m && indices[ops.get(pt)] < i){
                pt++;
            }
            boolean succeed = false;
            while (pt < m && indices[ops.get(pt)] == i){
                if (s.substring(i, Math.min(i + sources[ops.get(pt)].length(), n)).equals(sources[ops.get(pt)])){
                    succeed = true;
                    break;
                }
                pt++;
            }
            if (succeed){
                ans.append(targets[ops.get(pt)]);
                i += sources[ops.get(pt)].length();
            } else {
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();

    }
}
