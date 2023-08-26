package com.gao.leetcode;

/**
 * 2236. 判断根结点是否等于子结点之和
 * 给你一个 二叉树 的根结点 root，该二叉树由恰好 3 个结点组成：根结点、左子结点和右子结点。
 * 如果根结点值等于两个子结点值之和，返回 true ，否则返回 false 。
 */
public class CheckTree {

    public static void main(String[] args) {

    }

    public boolean checkTree(TreeNode02 root) {
        return root.val == root.left.val + root.right.val;
    }

}

class TreeNode02 {
    int val;
    TreeNode02 left;
    TreeNode02 right;

    TreeNode02() {}

    TreeNode02(int val) {
        this.val = val;
    }

    TreeNode02(int val, TreeNode02 left, TreeNode02 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}