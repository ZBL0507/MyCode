package com.zbl.algorithm.leetcode;

import com.zbl.ds.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class Test0038KthSmallest {
    private static List<Integer> cache = new ArrayList<>();
    private static TreeNode lastTreeRoot = null;

    @SuppressWarnings("Duplicates, unused")
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        treeNode6.left = treeNode5;
        treeNode6.right = treeNode7;
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode6;

        int i1 = kthSmallest(treeNode4, 2);
        int i2 = kthSmallest(treeNode4, 3);
        int i3 = kthSmallest(treeNode4, 1);
    }

    private static int kthSmallest(TreeNode root, int k) {
        if (root != lastTreeRoot) {
            lastTreeRoot = root;
            cache.clear();
        }

        if (!cache.isEmpty()) {
            return cache.get(k - 1);
        }

        process(root);
        return cache.get(k - 1);
    }

    private static void process(TreeNode treeNode) {
        if (treeNode == null)
            return;
        process(treeNode.left);
        cache.add(treeNode.val);
        process(treeNode.right);
    }
}
