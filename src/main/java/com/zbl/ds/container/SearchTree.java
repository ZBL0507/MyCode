package com.zbl.ds.container;

import com.zbl.ds.structure.TreeNode;

/**
 * 数据结构 - 二叉搜索树
 * 目前此二叉搜索树只支持int类型的数据，不支持其他类型的数据，
 * 里面存放的元素是不能重复的！
 * <p>
 * 这个类里面的某些公有方法应该定义为私有的，之所以是公有的是为了方便单元测试
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


    public TreeNode search(int key) {
        return search(root, key);
    }


    /**
     * 在一棵二叉搜索树中查找一个具有给定关键字的节点，输入一个树的根节点和一个关键字key
     * 如果找到则返回指向这个节点的引用，否则返回null
     *
     * @param root 指定的树根节点
     * @param key  要查找的关键字
     * @return 找到则返回指向这个节点的引用，否则返回null
     */
    private TreeNode search(TreeNode root, int key) {
        if (root == null || key == root.val)
            return root;

        //如果key和根节点相比较，小于则去左子树中寻找
        if (key < root.val)
            return search(root.left, key);

        //否则，则去右子树中去寻找
        return search(root.right, key);
    }

    public TreeNode minNode() {
        return minNode(root);
    }

    /**
     * 通过给定一个二叉搜索树的根节点，寻找这个树中最小元素节点
     *
     * @param root 给定的二叉搜索树的根节点
     * @return 这个树中最小元素节点
     */
    private TreeNode minNode(TreeNode root) {
        if (root == null)
            return null;

        //寻找整棵树最左边的节点，即为最小元素节点
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode maxNode() {
        return maxNode(root);
    }

    /**
     * 通过给定一个二叉搜索树的根节点，寻找这个树中最大元素节点
     *
     * @param root 给定的二叉搜索树的根节点
     * @return 这个树中最大元素节点
     */
    private TreeNode maxNode(TreeNode root) {
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
    public TreeNode successor(TreeNode treeNode) {
        if (treeNode == null)
            throw new NullPointerException();

        //有右子树的情况下，右子树中最小的节点即为要找的后继节点
        if (treeNode.right != null)
            return minNode(treeNode.right);

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

    /**
     * 给定一个二叉搜索树中的一个节点，寻找它的前驱节点
     *
     * @param treeNode 给定的节点
     * @return 给定节点的前驱节点， 如果有则返回前驱节点，如果没有就返回null
     */
    public TreeNode preDecessor(TreeNode treeNode) {
        if (treeNode == null)
            throw new NullPointerException();

        //如果有左子树，则左子树中最大的节点即为要找的前驱节点
        if (treeNode.left != null)
            return maxNode(treeNode.left);

        //记录treeNode的父节点
        TreeNode parent = treeNode.parent;
        if (parent != null) {
            //如果treeNode是一个右孩子，那么parent就是它的前驱节点
            if (treeNode == parent.right)
                return parent;
            else {
                //如果treeNode是一个左孩子，则向上找，treeNode，parent随之移动
                while (parent != null && treeNode == parent.left) {
                    treeNode = parent;
                    parent = parent.parent;
                }
                /*
                 * 退出while时，有两种情况
                 * 1：parent == null,这说明了最初的treeNode是树中最左边的节点，它没有前驱，亦即前驱为null
                 * 2：treeNode != parent.right (这里的treeNode和parent是已经移动后的) 这时treeNode为parent的右孩子
                 *    这时的parent必是最初的treeNode的前驱节点
                 */
                return parent;
            }

        }

        //没有左子树，也没有父节点，则它没有前驱节点
        return null;
    }


    /**
     * 向搜索树中插入一个节点
     *
     * @param value 待插入的数值
     * @return 插入成功返回true， 否则返回false
     */
    public boolean insert(int value) {
        //如果树为空
        if (root == null) {
            root = new TreeNode(value);
            return true;
        }

        TreeNode parent = findValueParent4Insert(value);
        if (parent == null)
            return false;
        if (value < parent.val) {
            //插入为左孩子
            TreeNode node = new TreeNode(value);
            parent.left = node;
            node.parent = parent;
        } else {
            //插入为右孩子
            TreeNode node = new TreeNode(value);
            parent.right = node;
            node.parent = parent;
        }

        return true;
    }

    /**
     * 寻找value的父节点，当以value为值的节点不存在时，返回的就是插入位置的父节点，
     * 如果以value为值的节点存在时，直接返回null
     * 如果树为空的时候，也直接返回null
     *
     * @param value 给定一个值（通常是插入时的值）
     * @return 插入位置的父节点
     */
    private TreeNode findValueParent4Insert(int value) {
        if (root == null)
            return null;

        TreeNode p = null, q = root;
        while (q != null) {
            p = q;
            if (value < q.val) {
                q = q.left;
            } else if (value > q.val) {
                q = q.right;
            } else {
                //存在重复的值，返回null
                return null;
            }
        }

        return p;
    }

    /**
     * 将搜索树转化为一个动态数组
     *
     * @return 返回转化后的动态数组
     */
    public DynamicArray<Integer> toDynamicArray() {
        DynamicArray<Integer> array = new DynamicArray<>();
        if (root == null)
            return array;

        collectElement(array, root);
        return array;
    }

    /**
     * 收集元素进动态数组
     *
     * @param array 动态数组
     * @param root  搜索树的根节点
     */
    private void collectElement(DynamicArray<Integer> array, TreeNode root) {
        if (root != null) {
            collectElement(array, root.left);
            array.add(root.val);
            collectElement(array, root.right);
        }
    }


    /**
     * 删除搜索树中以value为值的节点
     *
     * @param value 待删除的值
     * @return 删除成功返回true，失败返回false
     */
    public boolean delete(int value) {
        //树为空，不做任何处理
        if (this.root == null)
            return true;

        TreeNode deleteNode = findNodeByValue(value);
        //待删除的节点在树中不存在，不做任何处理
        if (deleteNode == null)
            return true;

        if (deleteNode.right == null) //待删除的节点没有右孩子
            transPlant(deleteNode, deleteNode.left);
        else if (deleteNode.left == null) //待删除的节点没有左孩子
            transPlant(deleteNode, deleteNode.right);
        else {
            //获取待删除节点的后继节点
            TreeNode successorNode = successor(deleteNode);
            if (successorNode.parent != deleteNode) {
                transPlant(successorNode, successorNode.right);
                successorNode.right = deleteNode.right;
                successorNode.right.parent = successorNode;
            }
            transPlant(deleteNode, successorNode);
            successorNode.left = deleteNode.left;
            successorNode.left.parent = successorNode;
        }

        return true;
    }

    /**
     * 树的替换：用一棵以v为根的子树替换一棵以u为根的子树
     * 这个方法不是通用的，因为在某些情况下使用有可能会导致一些未定义的错误，例如：调用之后某些指针不能正确的指向，不能正确的断开
     * 这个方法调用后也有可能会导致搜索树的特性会被破坏
     * 目前这个方法是配合{@link com.zbl.ds.container.SearchTree#delete(int)}方法使用的
     *
     * @param u 被替换的子树根节点
     * @param v 替换的子树根节点(最后保留下来的子树)
     */
    public void transPlant(TreeNode u, TreeNode v) {
        //如果被替换的这个树是null，则不做任何处理
        if (u == null)
            return;

        //如果u是根节点，则v成为新的树
        if (u.parent == null)
            this.root = v;
            //否则，如果u是一个左孩子
        else if (u.parent.left == u)
            u.parent.left = v;
            //否则，u是右孩子
        else
            u.parent.right = v;

        //处理v的父指针指向
        if (v != null)
            v.parent = u.parent;
    }


    /**
     * 根据value在搜索树中查找其相对应的节点，找到后返回相应的节点，如果没有找到则返回null
     *
     * @param value 指定的值
     * @return 找到后返回相应的节点，如果没有找到则返回null
     */
    public TreeNode findNodeByValue(int value) {
        TreeNode p = root;
        while (p != null && p.val != value) {
            if (value > p.val)
                p = p.right;
            if (value < p.val)
                p = p.left;
        }
        return p;
    }
}
