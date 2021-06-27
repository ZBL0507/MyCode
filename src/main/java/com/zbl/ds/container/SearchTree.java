package com.zbl.ds.container;

import com.zbl.ds.structure.TreeNode;

/**
 * 数据结构-二叉搜索树
 *
 * @author zbl
 * @version 1.0
 * @since 2021/6/26 20:12
 */
public class SearchTree {
    /**
     * 二叉搜索树的根节点
     */
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 无参构造器
     */
    public SearchTree() {
    }

    /**
     * 有参构造器
     * 用一个给定的二叉搜索树根节点构建一个二叉搜索树，这里其实是复用了已有的二叉搜索树，并没有做深拷贝
     *
     * @param root 给定的一个二叉搜索树根节点
     */
    public SearchTree(TreeNode root) {
        this.root = root;
    }

    /**
     * 二叉搜索树的中序遍历
     */
    public void inorderTreeWalk() {
        inorderTreeWalk(root);
    }

    /**
     * 根据给定的根节点中序遍历 二叉树
     *
     * @param root 给定的根节点
     */
    private void inorderTreeWalk(TreeNode root) {
        if (root != null) {
            inorderTreeWalk(root.left);
            System.out.print(root.val + "  ");
            inorderTreeWalk(root.right);
        }
    }


    public TreeNode treeSearch(int key) {
        return treeSearch(root, key);
    }


    /**
     * 在一棵二叉搜索树中查找一个具有给定关键字的节点，输入一个树的根节点和一个关键字key
     * 如果找到则返回指向这个节点的引用，否则返回null
     *
     * @param root 指定的树根节点
     * @param key  要查找的关键字
     * @return 找到则返回指向这个节点的引用，否则返回null
     */
    private TreeNode treeSearch(TreeNode root, int key) {
        if (root == null || key == root.val)
            return root;

        //如果key和根节点相比较，小于则去左子树中寻找
        if (key < root.val)
            return treeSearch(root.left, key);

        //否则，则去右子树中去寻找
        return treeSearch(root.right, key);
    }

    public TreeNode TreeMinimum() {
        return treeMinimum(root);
    }

    /**
     * 通过给定一个二叉搜索树的根节点，寻找这个树中最小元素节点
     *
     * @param root 给定的二叉搜索树的根节点
     * @return 这个树中最小元素节点
     */
    private TreeNode treeMinimum(TreeNode root) {
        if (root == null)
            return null;

        //寻找整棵树最左边的节点，即为最小元素节点
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode treeMaximum() {
        return treeMaximum(root);
    }

    /**
     * 通过给定一个二叉搜索树的根节点，寻找这个树中最大元素节点
     *
     * @param root 给定的二叉搜索树的根节点
     * @return 这个树中最大元素节点
     */
    private TreeNode treeMaximum(TreeNode root) {
        if (root == null)
            return null;

        //寻找整棵树最右边的节点，即为最大元素节点
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    /**
     * 给定一个二叉搜索树中的一个节点，寻找它的后继节点
     *
     * @param treeNode 给定的节点
     * @return 给定节点的后继节点
     */
    public TreeNode treeSuccessor(TreeNode treeNode) {
        if (treeNode == null)
            throw new NullPointerException();

        //有右子树的情况下，右子树中最小的节点即为要找的后继节点
        if (treeNode.right != null)
            return treeMinimum(treeNode.right);

        //记录treeNode的父节点
        TreeNode parent = treeNode.parent;
        if (parent != null) {
            //如果treeNode是一个左孩子，那么parent就是它的后继节点
            if (treeNode == parent.left)
                return parent;
            else {
                //如果treeNode是一个右孩子，则向上找，treeNode，parent随之移动
                while (parent != null && treeNode == parent.right) {
                    treeNode = parent;
                    parent = parent.parent;
                }
                /*
                 * 退出while时，有两种情况
                 * 1：parent == null,这说明了最初的treeNode是树中最右边的节点，它没有后继，亦即后继为null
                 * 2：treeNode != parent.right (这里的treeNode和parent是已经移动后的) 这时treeNode为parent的左孩子
                 *    这时的parent必是最初的treeNode的后继节点
                 */
                return parent;
            }
        }

        //没有右子树，也没有父节点
        return null;
    }
}
