package com.zbl.algorithm.leetcode;

import com.zbl.ds.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 */
public class Test0029 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        List<Integer> list = postorderTraversal(treeNode1);
        System.out.println(list);
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        process(root, list);
        return list;
    }

    private static void process(TreeNode node, List<Integer> list) {
        if (null == node)
            return;
        process(node.left, list);
        process(node.right, list);
        list.add(node.val);
    }
}
