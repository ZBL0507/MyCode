package com.zbl.algorithm.leetcode;

import com.zbl.ds.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
@SuppressWarnings("unused")
public class Test0028InorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        List<Integer> list = inorderTraversal(treeNode1);
        List<Integer> list2 = inorderTraversalNonRecursion(treeNode1);
        System.out.println(list);
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        process(root, list);
        return list;
    }

    private static void process(TreeNode node, List<Integer> list) {
        if (null == node)
            return;
        process(node.left, list);
        list.add(node.val);
        process(node.right, list);
    }

    /**
     * 二叉树中序遍历，非递归
     * 1.根节点先压栈
     * 2.如果有左孩子，左孩子压栈  这个左孩子如果还有左孩子，继续压栈，直到没有左孩子
     * 3.弹栈，处理这个弹出的节点，如果这个弹出的节点有右孩子，右孩子压栈，这个右孩子进行 2 步骤处理
     * 周而复始，直至栈为空，遍历结束
     *
     * @param root 二叉树根节点
     * @return 遍历结果
     */
    private static List<Integer> inorderTraversalNonRecursion(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            while (!stack.isEmpty() || p != null) {
                //这个for会将某个子树的整个左边压栈
                for (; p != null; p = p.left)
                    stack.push(p);
                TreeNode cur = stack.pop();
                list.add(cur.val);
                p = cur.right;
            }
        }
        return list;
    }
}
