package com.zbl.algorithm.leetcode;

import com.zbl.ds.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class Test0027PreorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode1;
        List<Integer> list = preorderTraversal(treeNode3);
        System.out.println(list);
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        process(root, list);
        return list;
    }

    private static void process(TreeNode node, List<Integer> list) {
        if (null == node)
            return;
        list.add(node.val);
        process(node.left, list);
        process(node.right, list);
    }
}
