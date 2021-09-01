package com.zbl.algorithm.leetcode.primary;

import com.zbl.ds.structure.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * @author zbl
 * @version 1.0
 * @since 2021/6/23 15:35
 */
public class Test0042ZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);

        treeNode3.left = treeNode2;
        treeNode3.right = treeNode1;
        treeNode5.left = treeNode3;
        treeNode5.right = treeNode4;

        List<List<Integer>> levelOrder = zigzagLevelOrder(treeNode5);
        System.out.println(levelOrder);
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrderResult = levelOrder(root);
        for (int i = 1; i < levelOrderResult.size(); i = i + 2) {
            Collections.reverse(levelOrderResult.get(i));
        }
        return levelOrderResult;
    }

    //层序遍历并分层
    @SuppressWarnings("Duplicates")
    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> curLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();

        curLevel.add(root);

        while (!curLevel.isEmpty() || !nextLevel.isEmpty()) {
            ArrayList<Integer> fromList = new ArrayList<>();
            ArrayList<Integer> toList = new ArrayList<>();

            while (!curLevel.isEmpty()) {
                TreeNode treeNode = curLevel.poll();
                fromList.add(treeNode.val);
                if (treeNode.left != null)
                    nextLevel.add(treeNode.left);
                if (treeNode.right != null)
                    nextLevel.add(treeNode.right);
            }
            if (!fromList.isEmpty())
                result.add(fromList);

            while (!nextLevel.isEmpty()) {
                TreeNode treeNode = nextLevel.poll();
                toList.add(treeNode.val);
                if (treeNode.left != null)
                    curLevel.add(treeNode.left);
                if (treeNode.right != null)
                    curLevel.add(treeNode.right);
            }
            if (!toList.isEmpty())
                result.add(toList);
        }

        return result;
    }
}
