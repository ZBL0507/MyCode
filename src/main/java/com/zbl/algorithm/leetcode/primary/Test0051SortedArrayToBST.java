package com.zbl.algorithm.leetcode.primary;

import com.zbl.ds.structure.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * @author zbl
 * @version 1.0
 * @since 2021/8/12 9:25
 */
@SuppressWarnings("unused")
public class Test0051SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode treeNode = sortedArrayToBST(nums);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1)
            return null;

        TreeNode root = new TreeNode();
        handle(root, nums, 0, nums.length - 1);
        return root;
    }


    private static void handle(TreeNode root, int[] nums, int begin, int end) {
        int midIndex = findMidIndex(begin, end);
        root.val = nums[midIndex];

        int leftEnd = midIndex - 1;
        if (begin <= leftEnd) {
            root.left = new TreeNode();
            handle(root.left, nums, begin, leftEnd);
        }

        int rightBegin = midIndex + 1;
        if (rightBegin <= end) {
            root.right = new TreeNode();
            handle(root.right, nums, rightBegin, end);
        }
    }

    private static int findMidIndex(int begin, int end) {
        return (begin + end) / 2;
    }
}
