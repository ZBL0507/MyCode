package com.zbl.algorithm.leetcode;

import com.zbl.ds.structure.TreeNode;

/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *   3
 *  / \
 * 9   20
 *    /  \
 *   15   7
 * 返回它的最大深度 3 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnd69e/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0021 {
    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode();
        TreeNode tn2 = new TreeNode();
        TreeNode tn3 = new TreeNode();
        TreeNode tn4 = new TreeNode();
        TreeNode tn5 = new TreeNode();
        tn3.left = tn4;
        tn3.right = tn5;
        tn1.left = tn2;
        tn1.right = tn3;
        int i = maxDepth(tn1);
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *      int val;
     *      TreeNode left;
     *      TreeNode right;
     *      TreeNode() {}
     *      TreeNode(int val) { this.val = val; }
     *      TreeNode(int val, TreeNode left, TreeNode right) {
     *          this.val = val;
     *          this.left = left;
     *          this.right = right;
     *      }
     * }
     */
    private static int maxDepth(TreeNode root) {
        if (null == root)
            return 0;
        if (root.left != null && root.right != null)
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        else if (root.right != null)
            return 1 + maxDepth(root.right);
        else if (root.left != null)
            return 1 + maxDepth(root.left);
        else
            return 1;
    }
}
