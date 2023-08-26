package com.gao.leetcode;

import javax.swing.tree.TreeNode;

/**
 * 1448. 统计二叉树中好节点的数目
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 *
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 */
public class GoodNodes {

    public static void main(String[] args) {

    }

    public static int goodNodes(TreeNode001 root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public static int dfs(TreeNode001 root, int pathMax){
        if (root == null){
            return 0;
        }
        int res = 0;
        if (root.val >= pathMax){
            res++;
            pathMax = root.val;
        }
        res += dfs(root.left, pathMax) + dfs(root.right, pathMax);
        return res;
    }

}

class TreeNode001 {
    int val;
    TreeNode001 left;
    TreeNode001 right;
    TreeNode001() {}
    TreeNode001(int val) { this.val = val; }
    TreeNode001(int val, TreeNode001 left, TreeNode001 right) {
        this.val = val;
        this.left = left;
         this.right = right;
    }
}