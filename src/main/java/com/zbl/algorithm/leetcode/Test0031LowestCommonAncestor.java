package com.zbl.algorithm.leetcode;

import com.zbl.ds.structure.TreeNode;

/**
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xopaih/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0031LowestCommonAncestor {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        TreeNode treeNode11 = lowestCommonAncestor(treeNode1, treeNode4, treeNode5);
        TreeNode treeNode22 = lowestCommonAncestor(treeNode1, treeNode3, treeNode5);

    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null || root == p || root == q)
            return root;

        TreeNode treeNodeLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode treeNodeRight = lowestCommonAncestor(root.right, p, q);
        if (treeNodeLeft != null && treeNodeRight != null)
            return root;
        return treeNodeLeft != null ? treeNodeLeft : treeNodeRight;
    }
}
