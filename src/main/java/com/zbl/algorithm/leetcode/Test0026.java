package com.zbl.algorithm.leetcode;

import com.zbl.ds.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Test0026 {

    public static void main(String[] args) {
        testInOrderPint();
    }

    private static boolean isValidBST_V1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrderAccess(root, list);

        for (int i = 1; i < list.size(); i++)
            if (list.get(i) <= list.get(i - 1))
                return false;

        return true;
    }

    private static void inOrderAccess(TreeNode root, List<Integer> list) {
        if (null == root)
            return;
        inOrderAccess(root.left, list);
        list.add(root.val);
        inOrderAccess(root.right, list);
    }

    private static void testInOrderPint() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode16 = new TreeNode(16);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode17 = new TreeNode(17);

        treeNode3.left = treeNode1;
        treeNode16.left = treeNode9;
        treeNode16.right = treeNode17;
        treeNode7.left = treeNode3;
        treeNode7.right = treeNode16;

        inOrderPint(treeNode7);
        isValidBST_V1(treeNode7);
    }

    private static void inOrderPint(TreeNode root) {
        if (null == root)
            return;
        inOrderPint(root.left);
        System.out.print(root.val + "  ");
        inOrderPint(root.right);
    }
}
