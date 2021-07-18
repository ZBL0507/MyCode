package com.zbl.mytest.container;

import com.zbl.ds.container.RBTree;
import com.zbl.ds.structure.RBTreeNode;
import org.junit.Test;

/**
 * @author zbl
 * @version 1.0
 * @since 2021/7/18 16:27
 */
public class RBTreeTest {
    @Test
    public void testLeftRotate() {
        RBTree rbTree = new RBTree();
        RBTreeNode rbTreeNode1 = new RBTreeNode(1);
        RBTreeNode rbTreeNode2 = new RBTreeNode(2);
        RBTreeNode rbTreeNode3 = new RBTreeNode(3);

        rbTreeNode1.left = RBTree.LEAF;
        rbTreeNode1.right = RBTree.LEAF;
        rbTreeNode1.parent = rbTreeNode2;

        rbTreeNode3.left = RBTree.LEAF;
        rbTreeNode3.right = RBTree.LEAF;
        rbTreeNode3.parent = rbTreeNode2;

        rbTreeNode2.left = rbTreeNode1;
        rbTreeNode2.right = rbTreeNode3;
        rbTreeNode2.parent = RBTree.LEAF;

        rbTree.setRoot(rbTreeNode2);

        rbTree.leftRotate(rbTreeNode2);
    }
}
