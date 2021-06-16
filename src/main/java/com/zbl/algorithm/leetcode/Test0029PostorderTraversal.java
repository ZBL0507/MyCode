package com.zbl.algorithm.leetcode;

import com.zbl.ds.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 */
@SuppressWarnings("unused")
public class Test0029PostorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        List<Integer> list = postorderTraversal(treeNode1);
        List<Integer> list2 = postorderTraversalNonRecursion(treeNode1);
        System.out.println(list);
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        process(root, list);
        return list;
    }

    private static void process(TreeNode node, List<Integer> list) {
        if (null == node)
            return;
        process(node.left, list);
        process(node.right, list);
        list.add(node.val);
    }

    /**
     * 二叉树后序遍历，非递归
     * 需要两个栈来完成非递归
     * 1.首先将根节点压栈
     * 2.栈不为空，弹出元素压入帮助栈
     * 3.弹出的这个元素左孩子(如果有)压栈,右孩子(如果有)压栈
     * 重复步骤 2 3 周而复始， 最终帮助栈保存了结果，帮助栈依次弹栈可得到后续遍历结果
     *
     * @param root 二叉树根节点
     * @return 遍历结果
     */
    private static List<Integer> postorderTraversalNonRecursion(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> helpStack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                helpStack.push(cur);
                if (cur.left != null)
                    stack.push(cur.left);
                if (cur.right != null)
                    stack.push(cur.right);
            }
            while (!helpStack.isEmpty())
                list.add(helpStack.pop().val);
        }
        return list;
    }
}
