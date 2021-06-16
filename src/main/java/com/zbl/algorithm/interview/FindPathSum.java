package com.zbl.algorithm.interview;

import com.zbl.ds.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法考核：给定一个二叉树和一个值sum,
 * 请找出所有的根节点到叶子节点的节点值之和等于sum的路径集合
 */
@SuppressWarnings("unused")
public class FindPathSum {
    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode11.left = treeNode2;
        treeNode11.right = treeNode7;
        treeNode4.left = treeNode1;
        treeNode4.right = treeNode11;
        treeNode8.right = treeNode9;
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;

        List<List<Integer>> pathSum = findPathSum(treeNode5, 22);
        List<List<Integer>> pathSum2 = findPathSum(treeNode5, 10);
    }

    /**
     * 给定一个二叉树和一个值sum, 请找出所有的根节点到叶子节点的节点值之和等于sum的路径集合
     *
     * @param root 给定的二叉树
     * @param sum  指定的路径和
     * @return 所有等于sum的路径集合
     */
    private static List<List<Integer>> findPathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        process(root, sum, tempList, resultList);
        return resultList;
    }

    /**
     * 核心步骤，递归的去寻找满足条件的所有路径和
     *
     * @param treeNode   寻找路径和的过程中，某一时刻走到的节点
     * @param sum        寻找路径和的过程中，某一时刻的路径和
     * @param tempList   临时存储路径和的列表，不一定是满足条件的路径和
     * @param resultList 保存满足条件路径和的列表
     */
    private static void process(TreeNode treeNode, int sum, List<Integer> tempList, List<List<Integer>> resultList) {
        if (treeNode == null)
            return;

        if (treeNode.left == null && treeNode.right == null && sum == treeNode.val) {
            //此if中说明已经找到一个满足条件的路径和
            tempList.add(treeNode.val);
            resultList.add(tempList);
            return;
        }

        //临时列表复制一份，去左子树中去寻找满足条件的路径和
        List<Integer> tempList4Left = new ArrayList<>(tempList);
        tempList4Left.add(treeNode.val);
        process(treeNode.left, sum - treeNode.val, tempList4Left, resultList);

        //临时列表复制一份，去右子树中去寻找满足条件的路径和
        List<Integer> tempList4Right = new ArrayList<>(tempList);
        tempList4Right.add(treeNode.val);
        process(treeNode.right, sum - treeNode.val, tempList4Right, resultList);
    }
}
