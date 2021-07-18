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


    @Test
    public void testLeftRotate2() {
        RBTree rbTree = new RBTree();
        RBTreeNode rbTreeNode1 = new RBTreeNode(1);
        RBTreeNode rbTreeNode2 = new RBTreeNode(2);
        RBTreeNode rbTreeNode3 = new RBTreeNode(3);

        rbTreeNode1.left = RBTree.LEAF;
        rbTreeNode1.right = rbTreeNode2;
        rbTreeNode1.parent = RBTree.LEAF;

        rbTreeNode2.left = RBTree.LEAF;
        rbTreeNode2.right = rbTreeNode3;
        rbTreeNode2.parent = rbTreeNode1;

        rbTreeNode3.left = RBTree.LEAF;
        rbTreeNode3.right = RBTree.LEAF;
        rbTreeNode3.parent = rbTreeNode2;

        rbTree.setRoot(rbTreeNode1);

        rbTree.leftRotate(rbTreeNode1);
    }

    @Test
    public void testLeftRotate3() {
        RBTree rbTree = new RBTree();
        RBTreeNode rbTreeNode1 = new RBTreeNode(1);
        RBTreeNode rbTreeNode2 = new RBTreeNode(2);
        RBTreeNode rbTreeNode3 = new RBTreeNode(3);
        RBTreeNode rbTreeNode4 = new RBTreeNode(4);
        RBTreeNode rbTreeNode5 = new RBTreeNode(5);

        rbTreeNode1.left = RBTree.LEAF;
        rbTreeNode1.right = RBTree.LEAF;
        rbTreeNode1.parent = rbTreeNode2;

        rbTreeNode3.left = RBTree.LEAF;
        rbTreeNode3.right = RBTree.LEAF;
        rbTreeNode3.parent = rbTreeNode4;

        rbTreeNode5.left = RBTree.LEAF;
        rbTreeNode5.right = RBTree.LEAF;
        rbTreeNode5.parent = rbTreeNode4;

        rbTreeNode4.left = rbTreeNode3;
        rbTreeNode4.right = rbTreeNode5;
        rbTreeNode4.parent = rbTreeNode2;

        rbTreeNode2.left = rbTreeNode1;
        rbTreeNode2.right = rbTreeNode4;
        rbTreeNode2.parent = RBTree.LEAF;


        rbTree.setRoot(rbTreeNode2);

        rbTree.leftRotate(rbTreeNode2);
    }

    @Test
    public void testLeftRotate4() {
        RBTree rbTree = new RBTree();
        RBTreeNode rbTreeNode1 = new RBTreeNode(1);
        RBTreeNode rbTreeNode2 = new RBTreeNode(2);
        RBTreeNode rbTreeNode3 = new RBTreeNode(3);
        RBTreeNode rbTreeNode4 = new RBTreeNode(4);
        RBTreeNode rbTreeNode5 = new RBTreeNode(5);
        RBTreeNode rbTreeNode6 = new RBTreeNode(6);

        rbTreeNode1.left = RBTree.LEAF;
        rbTreeNode1.right = RBTree.LEAF;
        rbTreeNode1.parent = rbTreeNode2;

        rbTreeNode3.left = RBTree.LEAF;
        rbTreeNode3.right = RBTree.LEAF;
        rbTreeNode3.parent = rbTreeNode4;

        rbTreeNode5.left = RBTree.LEAF;
        rbTreeNode5.right = RBTree.LEAF;
        rbTreeNode5.parent = rbTreeNode4;

        rbTreeNode4.left = rbTreeNode3;
        rbTreeNode4.right = rbTreeNode5;
        rbTreeNode4.parent = rbTreeNode2;

        rbTreeNode2.left = rbTreeNode1;
        rbTreeNode2.right = rbTreeNode4;
        rbTreeNode2.parent = rbTreeNode6;

        rbTreeNode6.left = rbTreeNode2;
        rbTreeNode6.right = RBTree.LEAF;
        rbTreeNode6.parent = RBTree.LEAF;


        rbTree.setRoot(rbTreeNode6);

        rbTree.leftRotate(rbTreeNode2);
    }

    @Test
    public void testLeftRotate5() {
        RBTree rbTree = new RBTree();
        RBTreeNode rbTreeNode1 = new RBTreeNode(1);
        RBTreeNode rbTreeNode2 = new RBTreeNode(2);
        RBTreeNode rbTreeNode3 = new RBTreeNode(3);
        RBTreeNode rbTreeNode4 = new RBTreeNode(4);
        RBTreeNode rbTreeNode5 = new RBTreeNode(5);
        RBTreeNode rbTreeNode0 = new RBTreeNode(0);

        rbTreeNode1.left = RBTree.LEAF;
        rbTreeNode1.right = RBTree.LEAF;
        rbTreeNode1.parent = rbTreeNode2;

        rbTreeNode3.left = RBTree.LEAF;
        rbTreeNode3.right = RBTree.LEAF;
        rbTreeNode3.parent = rbTreeNode4;

        rbTreeNode5.left = RBTree.LEAF;
        rbTreeNode5.right = RBTree.LEAF;
        rbTreeNode5.parent = rbTreeNode4;

        rbTreeNode4.left = rbTreeNode3;
        rbTreeNode4.right = rbTreeNode5;
        rbTreeNode4.parent = rbTreeNode2;

        rbTreeNode2.left = rbTreeNode1;
        rbTreeNode2.right = rbTreeNode4;
        rbTreeNode2.parent = rbTreeNode0;

        rbTreeNode0.right = rbTreeNode2;
        rbTreeNode0.left = RBTree.LEAF;
        rbTreeNode0.parent = RBTree.LEAF;


        rbTree.setRoot(rbTreeNode0);

        rbTree.leftRotate(rbTreeNode2);
    }

    @Test
    public void testRightRotate() {
        RBTree rbTree = new RBTree();
        RBTreeNode rbTreeNode1 = new RBTreeNode(1);
        RBTreeNode rbTreeNode2 = new RBTreeNode(2);
        RBTreeNode rbTreeNode3 = new RBTreeNode(3);

        rbTreeNode1.left = RBTree.LEAF;
        rbTreeNode1.right = RBTree.LEAF;
        rbTreeNode1.parent = rbTreeNode2;

        rbTreeNode2.left = rbTreeNode1;
        rbTreeNode2.right = RBTree.LEAF;
        rbTreeNode2.parent = rbTreeNode3;

        rbTreeNode3.left = rbTreeNode2;
        rbTreeNode3.right = RBTree.LEAF;
        rbTreeNode3.parent = RBTree.LEAF;

        rbTree.setRoot(rbTreeNode3);
        rbTree.rightRotate(rbTreeNode3);
    }

    @Test
    public void testRightRotate2() {
        RBTree rbTree = new RBTree();
        RBTreeNode rbTreeNode1 = new RBTreeNode(1);
        RBTreeNode rbTreeNode2 = new RBTreeNode(2);
        RBTreeNode rbTreeNode3 = new RBTreeNode(3);

        rbTreeNode1.left = RBTree.LEAF;
        rbTreeNode1.right = RBTree.LEAF;
        rbTreeNode1.parent = rbTreeNode2;

        rbTreeNode2.left = rbTreeNode1;
        rbTreeNode2.right = RBTree.LEAF;
        rbTreeNode2.parent = rbTreeNode3;

        rbTreeNode3.left = rbTreeNode2;
        rbTreeNode3.right = RBTree.LEAF;
        rbTreeNode3.parent = RBTree.LEAF;

        rbTree.setRoot(rbTreeNode3);
        rbTree.rightRotate(rbTreeNode1);
    }

    @Test
    public void testRightRotate3() {
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
        rbTree.rightRotate(rbTreeNode2);
    }

    @Test
    public void testRightRotate4() {
        RBTree rbTree = new RBTree();
        RBTreeNode rbTreeNode1 = new RBTreeNode(1);
        RBTreeNode rbTreeNode2 = new RBTreeNode(2);
        RBTreeNode rbTreeNode3 = new RBTreeNode(3);
        RBTreeNode rbTreeNode4 = new RBTreeNode(4);
        RBTreeNode rbTreeNode5 = new RBTreeNode(5);
        RBTreeNode rbTreeNode6 = new RBTreeNode(6);
        RBTreeNode rbTreeNode7 = new RBTreeNode(7);

        rbTreeNode1.left = RBTree.LEAF;
        rbTreeNode1.right = RBTree.LEAF;
        rbTreeNode1.parent = rbTreeNode2;

        rbTreeNode3.left = RBTree.LEAF;
        rbTreeNode3.right = RBTree.LEAF;
        rbTreeNode3.parent = rbTreeNode2;

        rbTreeNode2.left = rbTreeNode1;
        rbTreeNode2.right = rbTreeNode3;
        rbTreeNode2.parent = rbTreeNode4;

        rbTreeNode5.left = RBTree.LEAF;
        rbTreeNode5.right = RBTree.LEAF;
        rbTreeNode5.parent = rbTreeNode4;

        rbTreeNode4.left = rbTreeNode2;
        rbTreeNode4.right = rbTreeNode5;
        rbTreeNode4.parent = rbTreeNode6;

        rbTreeNode7.left = RBTree.LEAF;
        rbTreeNode7.right = RBTree.LEAF;
        rbTreeNode7.parent = rbTreeNode6;

        rbTreeNode6.left = rbTreeNode4;
        rbTreeNode6.right = rbTreeNode7;
        rbTreeNode6.parent = RBTree.LEAF;

        rbTree.setRoot(rbTreeNode6);
        rbTree.rightRotate(rbTreeNode4);
    }
}
