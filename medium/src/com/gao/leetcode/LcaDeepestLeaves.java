package com.gao.leetcode;

import javafx.util.Pair;

/**
 *1123. 最深叶节点的最近公共祖先
 * 给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。
 *
 * 回想一下：
 *
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 *
 */
public class LcaDeepestLeaves {

    public static void main(String[] args) {

    }

    public TreeNode0906 lcaDeepestLeaves(TreeNode0906 root) {
        return f(root).getKey();
    }

    private Pair<TreeNode0906, Integer> f(TreeNode0906 root) {
        if (root == null) {
            return new Pair<>(root, 0);
        }

        Pair<TreeNode0906, Integer> left = f(root.left);
        Pair<TreeNode0906, Integer> right = f(root.right);

        if (left.getValue() > right.getValue()) {
            return new Pair<>(left.getKey(), left.getValue() + 1);
        }
        if (left.getValue() < right.getValue()) {
            return new Pair<>(right.getKey(), right.getValue() + 1);
        }
        return new Pair<>(root, left.getValue() + 1);
    }



}
class TreeNode0906 {
    int val;
    TreeNode0906 left;
    TreeNode0906 right;
    TreeNode0906() {}
    TreeNode0906(int val) { this.val = val; }
    TreeNode0906(int val, TreeNode0906 left, TreeNode0906 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}