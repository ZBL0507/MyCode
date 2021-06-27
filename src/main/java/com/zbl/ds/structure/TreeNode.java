package com.zbl.ds.structure;

/**
 * Definition for a binary tree node.
 */
@SuppressWarnings("unused")
public class TreeNode {
    public int val;
    //左孩子
    public TreeNode left;
    //右孩子
    public TreeNode right;
    //双亲节点
    public TreeNode parent;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
