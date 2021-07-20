package com.zbl.ds.container;

import com.zbl.ds.structure.RBTreeNode;

/**
 * 数据结构 - 红黑树
 * 目前红黑树节点{@link com.zbl.ds.structure.RBTreeNode}只支持int类型的数据
 * 所以目前采用int类型来演示算法
 * <p>
 * 红黑树的特性：
 * 1. 每个节点或红或黑
 * 2. 根节点是黑色的
 * 3. 每个叶子节点(NULL)是黑色的
 * 4. 如果一个节点是红色的，那么它的两个孩子都是黑色的
 * 5. 对于每个节点，从该节点到其所有后代叶子节点的简单路径上，均包含相同数目的黑色节点
 * <p>
 * 这个类里面的某些公有方法应该定义为私有的，之所以是公有的是为了方便单元测试
 *
 * @author zbl
 * @version 1.0
 * @since 2021/7/17 16:34
 */
public class RBTree {
    /**
     * 红黑树的根节点
     */
    private RBTreeNode root;

    /**
     * 哨兵节点(叶子节点)，为了方便和节省空间，所有叶子节点和根的父节点公用这个LEAF节点
     */
    public static final RBTreeNode LEAF = new RBTreeNode(RBTreeNode.BLACK);

    public RBTreeNode getRoot() {
        return root;
    }

    public void setRoot(RBTreeNode root) {
        this.root = root;
    }

    //无参构造器
    public RBTree() {
    }

    /**
     * 有参构造器
     * 用一个给定的红黑树根节点构建一个红黑树，这里其实是复用了已有的红黑树，并没有做深拷贝
     *
     * @param root 给定的一个红黑树根节点
     */
    public RBTree(RBTreeNode root) {
        this.root = root;
    }


    /**
     * 获取红黑树中最小的节点
     *
     * @return 红黑树中最小的节点
     */
    public RBTreeNode minNode() {
        return minNode(root);
    }

    /**
     * 通过给定一个红黑树的根节点，寻找这个子树中最小元素节点
     *
     * @param root 给定的红黑树的根节点
     * @return 这个树中最小元素节点
     */
    private RBTreeNode minNode(RBTreeNode root) {
        if (root == null || root == RBTree.LEAF)
            return root;

        //寻找整棵树最左边的节点，即为最小元素节点
        while (root.left != RBTree.LEAF) {
            root = root.left;
        }
        return root;
    }

    /**
     * 获取红黑树中最大的节点
     *
     * @return 红黑树中最大的节点
     */
    public RBTreeNode maxNode() {
        return maxNode(root);
    }

    /**
     * 通过给定一个红黑树的根节点，寻找这个红黑树中最大元素节点
     *
     * @param root 给定的红黑树的根节点
     * @return 这个树中最大元素节点
     */
    private RBTreeNode maxNode(RBTreeNode root) {
        if (root == null || root == RBTree.LEAF)
            return root;

        //寻找整棵树最右边的节点，即为最大元素节点
        while (root.right != RBTree.LEAF) {
            root = root.right;
        }
        return root;
    }


    /**
     * 红黑树操作 - 左旋
     * 以 x-y 为轴进行左旋
     * <p>
     * 1. 取x的右为y
     * 2. x的右指向y的左
     * 3. 如果y有左(亦即y的左不是{@link RBTree#LEAF}), 则将y的左的父指向x
     * 4. y的父指向x的父
     * 5. 如果x为根，则将y置为新的根；否则如果x为一个左孩子，则将x的父的左指向y；否则，将x的父的右指向y
     * 6. y的左指向x
     * 7. x的父指向y
     * <p>
     * 左旋的时间复杂度为O(1)
     *
     * @param x 旋转轴 x-y(y为x的右) 中的 x
     */
    @SuppressWarnings("all")
    public void leftRotate(RBTreeNode x) {
        if (x.right == RBTree.LEAF)
            return;

        //1. 取x的右为y
        RBTreeNode y = x.right;

        //2. x的右指向y的左
        x.right = y.left;
        if (y == RBTree.LEAF)
            return;

        //3. 如果y有左(亦即y的左不是{@link RBTree#LEAF}), 则将y的左的父指向x
        if (y.left != RBTree.LEAF)
            y.left.parent = x;

        //4. y的父指向x的父
        y.parent = x.parent;

        //5. 如果x为根，则将y置为新的根；否则如果x为一个左孩子，则将x的父的左指向y；否则，将x的父的右指向y
        if (x.parent == RBTree.LEAF) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        //6. y的左指向x
        y.left = x;

        //7. x的父指向y
        x.parent = y;
    }


    /**
     * 红黑树操作 - 右旋
     * 以 x-y 为轴进行右旋
     * 右旋操作可根据和左旋的对称性得出
     * <p>
     * 1. 取x的左为y
     * 2. x的左指向y的右
     * 3. y的右(若不是{@link RBTree#LEAF})的父指向x
     * 4. y的父指向x的父
     * 5. 如果x是根节点，则将y置为新的根节点；否则如果x是一个左孩子，则x的父的左指向y；否则x的父的右指向y
     * 6. y的右指向x
     * 7. x的父指向y
     * <p>
     * 右旋的时间复杂度为O(1)
     *
     * @param x 旋转轴 x-y(y为x的左) 中的 x
     */
    @SuppressWarnings("all")
    public void rightRotate(RBTreeNode x) {
        if (x == RBTree.LEAF)
            return;

        RBTreeNode y = x.left;
        if (y == RBTree.LEAF)
            return;

        x.left = y.right;
        if (y.right != RBTree.LEAF)
            y.right.parent = x;

        y.parent = x.parent;
        if (x.parent == RBTree.LEAF) {
            setRoot(y);
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.right = x;
        x.parent = y;
    }

    /**
     * 红黑树的中序遍历
     */
    public void inorderTreeWalk() {
        inorderTreeWalk(root);
        System.out.println();
    }

    /**
     * 根据给定的根节点中序遍历 红黑树
     *
     * @param root 给定的根节点
     */
    private void inorderTreeWalk(RBTreeNode root) {
        if (root != RBTree.LEAF) {
            inorderTreeWalk(root.left);
            System.out.print(root.val + "  ");
            inorderTreeWalk(root.right);
        }
    }

    public RBTreeNode search(int key) {
        return search(root, key);
    }


    /**
     * 在一棵红黑树中查找一个具有给定关键字的节点，输入一个树的根节点和一个关键字key
     * 如果找到则返回指向这个节点的引用，否则返回null
     *
     * @param root 指定的树根节点
     * @param key  要查找的关键字
     * @return 找到则返回指向这个节点的引用，否则返回null
     */
    private RBTreeNode search(RBTreeNode root, int key) {
        if (root == null || root == RBTree.LEAF)
            return null;
        if (key == root.val)
            return root;

        //如果key和根节点相比较，小于则去左子树中寻找
        if (key < root.val)
            return search(root.left, key);

        //否则，则去右子树中去寻找
        return search(root.right, key);
    }
}
