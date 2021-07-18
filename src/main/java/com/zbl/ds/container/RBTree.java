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
     * @param x 旋转轴 x-y 中的 x
     */
    public void leftRotate(RBTreeNode x) {
        if (x.right == RBTree.LEAF)
            return;

        //1. 取x的右为y
        RBTreeNode y = x.right;

        //2. x的右指向y的左
        x.right = y.left;

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
}
