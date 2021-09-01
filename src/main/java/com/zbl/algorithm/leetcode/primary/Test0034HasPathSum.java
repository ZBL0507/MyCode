package com.zbl.algorithm.leetcode.primary;

import com.zbl.ds.structure.TreeNode;

/**
 * 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xo566j/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0034HasPathSum {
    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode4_ = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(1);

        treeNode11.left = treeNode7;
        treeNode11.right = treeNode2;
        treeNode4.left = treeNode11;
        treeNode4_.right = treeNode1;
        treeNode8.left = treeNode13;
        treeNode8.right = treeNode4_;
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;

        boolean hasPathSum = hasPathSum(treeNode4_, 5);
        boolean hasPathSum1 = hasPathSum(treeNode5, 26);

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        boolean hasPathSum2 = hasPathSum(treeNode, 1);
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return process(root, targetSum);
    }

    private static boolean process(TreeNode treeNode, int targetSum) {
        if (null == treeNode)
            return false;
        if (treeNode.left == null && treeNode.right == null)
            return targetSum == treeNode.val;

        boolean leftResult = process(treeNode.left, targetSum - treeNode.val);
        //左子树存在满足条件的结果，即可返回，不必再进行右子树的递归
        if (leftResult)
            return true;
        return process(treeNode.right, targetSum - treeNode.val);
    }
}
