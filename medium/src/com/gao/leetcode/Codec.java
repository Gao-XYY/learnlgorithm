package com.gao.leetcode;


import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 */
public class Codec {

    public static void main(String[] args) {

    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode002 root) {
        List<Integer> list =  new ArrayList<>();
        postOrder(root, list);
        String str = list.toString();
        return str.substring(1, str.length() - 1);
    }

    private void postOrder(TreeNode002 root, List<Integer> list) {

        if (root == null){
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    // Decodes your encoded data to tree.
    public TreeNode002 deserialize(String data) {
        if (data.isEmpty()){
            return null;
        }
        String[] arr = data.split(", ");
        Deque<Integer> stack = new ArrayDeque<>();
        int length = arr.length;
        for (int i = 0; i < length; i++){
            stack.push(Integer.parseInt(arr[i]));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    private TreeNode002 construct(int lower, int upper, Deque<Integer> stack) {

        if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper){
            return null;
        }
        int val = stack.pop();
        TreeNode002 root = new TreeNode002(val);
        root.right = construct(val, upper, stack);
        root.left = construct(lower, val, stack);
        return root;
    }

}

class TreeNode002 {
    int val;
    TreeNode002 left;
    TreeNode002 right;
    TreeNode002(int x) { val = x; }
}