package com.zbl.algorithm.leetcode.primary;

import com.zbl.ds.structure.TreeNode;

import java.util.*;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
@SuppressWarnings("unused")
public class Test0030IsSymmetric {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;
        boolean symmetric = isSymmetric(treeNode1);

        TreeNode treeNode7 = new TreeNode(1);
        TreeNode treeNode8 = new TreeNode(1);
        TreeNode treeNode9 = new TreeNode(1);
        treeNode7.left = treeNode8;
        treeNode8.left = treeNode9;
        boolean symmetric1 = isSymmetric(treeNode7);
    }


    private static boolean isSymmetric(TreeNode root) {
        //base case
        if (root == null || (root.left == null && root.right == null))
            return true;

        List<List<String>> lists = levelOrder(root);
        for (List<String> list : lists) {
            int j = list.size() - 1;
            int i = 0;
            for (; i < j; i++, j--)
                if (!list.get(i).equals(list.get(j)))
                    return false;
        }

        return true;
    }

    //二叉树层序遍历
    @SuppressWarnings("Duplicates")
    private static List<List<String>> levelOrder(TreeNode root) {
        if (null == root)
            return Collections.emptyList();

        //记录结果, 未记录根节点的层， 从第二层开始记录
        List<List<String>> result = new ArrayList<>();
        //借助两个队列进行分层
        Queue<TreeNode> from = new LinkedList<>();
        Queue<TreeNode> to = new LinkedList<>();

        from.add(root);

        while (!from.isEmpty() || !to.isEmpty()) {
            //准备两个list记录分层
            List<String> fromList = new ArrayList<>();
            List<String> toList = new ArrayList<>();

            //from队列的节点全部出队，出队的时候顺便将下一层的节点入to队
            while (!from.isEmpty()) {
                //节点出队
                TreeNode treeNode = from.poll();
                if (treeNode.left != null) {
                    //左孩子节点数据域入list
                    fromList.add(treeNode.left.val + "");
                    //左孩子节点入队
                    to.add(treeNode.left);
                } else {
                    //如果左孩子为null 则往list里记录一个"null"方便之后判断是否对称
                    fromList.add("null");
                }
                if (treeNode.right != null) {
                    //右孩子节点数据域入list
                    fromList.add(treeNode.right.val + "");
                    //右孩子节点入队
                    to.add(treeNode.right);
                } else {
                    //如果右孩子为null 则往list里记录一个"null"方便之后判断是否对称
                    fromList.add("null");
                }
            }
            //list不为空的时候将list记录到结果集中去
            if (!fromList.isEmpty())
                result.add(fromList);

            //to队列做同样的处理
            while (!to.isEmpty()) {
                TreeNode treeNode = to.poll();
                if (treeNode.left != null) {
                    toList.add(treeNode.left.val + "");
                    from.add(treeNode.left);
                } else {
                    toList.add("null");
                }
                if (treeNode.right != null) {
                    toList.add(treeNode.right.val + "");
                    from.add(treeNode.right);
                } else {
                    toList.add("null");
                }
            }
            if (!toList.isEmpty())
                result.add(toList);
        }

        return result;
    }
}
