package com.zbl.algorithm.leetcode;

import com.zbl.ds.structure.TreeNode;

import java.util.*;

/**
 * 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnldjj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0022LevelOrder {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        levelPrint(treeNode1);
        levelOrder(treeNode1);

    }

    @SuppressWarnings("Duplicates")
    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> from = new LinkedList<>();
        Queue<TreeNode> to = new LinkedList<>();
        from.add(root);

        while (!from.isEmpty() || !to.isEmpty()) {

            ArrayList<Integer> fromList = new ArrayList<>();
            ArrayList<Integer> toList = new ArrayList<>();

            while (!from.isEmpty()) {
                TreeNode queueHead = from.poll();
                fromList.add(queueHead.val);
                if (queueHead.left != null)
                    to.add(queueHead.left);
                if (queueHead.right != null)
                    to.add(queueHead.right);
            }
            if (!fromList.isEmpty())
                result.add(fromList);

            while (!to.isEmpty()) {
                TreeNode queueHead = to.poll();
                toList.add(queueHead.val);
                if (queueHead.left != null)
                    from.add(queueHead.left);
                if (queueHead.right != null)
                    from.add(queueHead.right);
            }
            if (!toList.isEmpty())
                result.add(toList);

        }

        return result;
    }


    private static void levelPrint(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            System.out.print(head.val + "  ");
            if (head.left != null)
                queue.add(head.left);
            if (head.right != null)
                queue.add(head.right);
        }
    }

}
