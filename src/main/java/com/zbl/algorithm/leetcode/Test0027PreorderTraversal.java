package com.zbl.algorithm.leetcode;

import com.zbl.ds.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
@SuppressWarnings("unused")
public class Test0027PreorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode1;
        List<Integer> list = preorderTraversal(treeNode3);
        List<Integer> list1 = preorderTraversalNonRecursion(treeNode3);
        System.out.println(list);
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        process(root, list);
        return list;
    }

    private static void process(TreeNode node, List<Integer> list) {
        if (null == node)
            return;
        list.add(node.val);
        process(node.left, list);
        process(node.right, list);
    }

    /**
     * 二叉树遍历，非递归
     * 算法思想：1.根节点压栈
     * 2.栈不为空就弹栈处理这个节点
     * 3.弹出的这个节点如果有右子节点就将右子节点压栈，
     * 3.弹出的这个节点如果有左子节点就将左子节点压栈，
     * 再次进行 2 步骤 周而复始直到栈为空 遍历结束
     *
     * @param root 树的根节点
     * @return 先序遍历结果
     */
    private static List<Integer> preorderTraversalNonRecursion(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (null != root) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                list.add(cur.val);
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
        return list;
    }
}
