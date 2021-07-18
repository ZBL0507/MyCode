package com.zbl.ds.structure;

/**
 * 红黑树节点定义
 * Definition for a rb tree node.
 */
@SuppressWarnings("unused")
public class RBTreeNode {
    //值域
    public int val;

    //左孩子
    public RBTreeNode left;

    //右孩子
    public RBTreeNode right;

    //双亲节点
    public RBTreeNode parent;

    //节点颜色
    public String color;

    public static final String RED = "red";
    public static final String BLACK = "black";

    public RBTreeNode() {
    }

    public RBTreeNode(int val) {
        this.val = val;
    }

    public RBTreeNode(String color) {
        this.color = color;
    }

    public RBTreeNode(int val, RBTreeNode left, RBTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public RBTreeNode(int val, RBTreeNode left, RBTreeNode right, RBTreeNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public RBTreeNode(int val, RBTreeNode left, RBTreeNode right, RBTreeNode parent, String color) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.color = color;
    }
}
