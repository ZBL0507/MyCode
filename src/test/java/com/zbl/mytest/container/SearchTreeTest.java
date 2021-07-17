package com.zbl.mytest.container;

import com.zbl.ds.container.DynamicArray;
import com.zbl.ds.container.SearchTree;
import com.zbl.ds.structure.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * @author zbl
 * @version 1.0
 * @since 2021/6/26 21:29
 */
@SuppressWarnings("unused")
public class SearchTreeTest {

    private TreeNode root;

    @Before
    public void initSearchTree() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);

        treeNode3.right = treeNode4;

        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;

        treeNode7.left = treeNode6;

        treeNode10.left = treeNode9;
        treeNode10.right = treeNode11;

        treeNode8.left = treeNode7;
        treeNode8.right = treeNode10;

        treeNode5.left = treeNode2;
        treeNode5.right = treeNode8;

        treeNode1.parent = treeNode2;
        treeNode2.parent = treeNode5;
        treeNode3.parent = treeNode2;
        treeNode4.parent = treeNode3;
        treeNode6.parent = treeNode7;
        treeNode7.parent = treeNode8;
        treeNode8.parent = treeNode5;
        treeNode9.parent = treeNode10;
        treeNode10.parent = treeNode8;
        treeNode11.parent = treeNode10;

        root = treeNode5;
    }

    @Test
    public void inorderTreeWalk() {
        SearchTree searchTree = new SearchTree(root);
        searchTree.inorderTreeWalk();
    }

    @Test
    public void treeMaximum() {
        SearchTree searchTree = new SearchTree();
        searchTree.setRoot(root);
        TreeNode treeNode = searchTree.treeMaximum();
        System.out.println(treeNode.val);
    }

    @Test
    public void TreeMinimum() {
        SearchTree searchTree = new SearchTree(root);
        TreeNode treeNode = searchTree.TreeMinimum();
        System.out.println(treeNode.val);
    }

    @Test
    public void treeSearch() {
        SearchTree searchTree = new SearchTree(root);
        TreeNode treeNode = searchTree.treeSearch(-1);
        if (treeNode == null) {
            System.out.println("没有找到");
            return;
        }
        System.out.println(treeNode.val);
    }

    @Test
    public void treeSuccessor() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);

        treeNode3.right = treeNode4;

        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;

        treeNode7.left = treeNode6;

        treeNode10.left = treeNode9;
        treeNode10.right = treeNode11;

        treeNode8.left = treeNode7;
        treeNode8.right = treeNode10;

        treeNode5.left = treeNode2;
        treeNode5.right = treeNode8;

        treeNode1.parent = treeNode2;
        treeNode2.parent = treeNode5;
        treeNode3.parent = treeNode2;
        treeNode4.parent = treeNode3;
        treeNode6.parent = treeNode7;
        treeNode7.parent = treeNode8;
        treeNode8.parent = treeNode5;
        treeNode9.parent = treeNode10;
        treeNode10.parent = treeNode8;
        treeNode11.parent = treeNode10;

        root = treeNode5;

        SearchTree searchTree = new SearchTree(treeNode5);

        TreeNode successor = searchTree.treeSuccessor(treeNode5);
        if (successor != null) {
            System.out.println("treeNode5后继:" + successor.val);
        } else {
            System.out.println("treeNode5没有后继");
        }

        TreeNode successor1 = searchTree.treeSuccessor(treeNode1);
        if (successor1 != null) {
            System.out.println("treeNode1后继:" + successor1.val);
        } else {
            System.out.println("treeNode1没有后继");
        }

        TreeNode successor3 = searchTree.treeSuccessor(treeNode3);
        if (successor3 != null) {
            System.out.println("treeNode3后继:" + successor3.val);
        } else {
            System.out.println("treeNode3没有后继");
        }

        TreeNode successor4 = searchTree.treeSuccessor(treeNode4);
        if (successor4 != null) {
            System.out.println("treeNode4后继:" + successor4.val);
        } else {
            System.out.println("treeNode4没有后继");
        }

        TreeNode successor11 = searchTree.treeSuccessor(treeNode11);
        if (successor11 != null) {
            System.out.println("treeNode11后继:" + successor11.val);
        } else {
            System.out.println("treeNode11没有后继");
        }

        TreeNode successor6 = searchTree.treeSuccessor(treeNode6);
        if (successor6 != null) {
            System.out.println("treeNode6后继:" + successor6.val);
        } else {
            System.out.println("treeNode6没有后继");
        }
    }

    @Test
    public void treePreDecessor() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);

        treeNode3.right = treeNode4;

        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;

        treeNode7.left = treeNode6;

        treeNode10.left = treeNode9;
        treeNode10.right = treeNode11;

        treeNode8.left = treeNode7;
        treeNode8.right = treeNode10;

        treeNode5.left = treeNode2;
        treeNode5.right = treeNode8;

        treeNode1.parent = treeNode2;
        treeNode2.parent = treeNode5;
        treeNode3.parent = treeNode2;
        treeNode4.parent = treeNode3;
        treeNode6.parent = treeNode7;
        treeNode7.parent = treeNode8;
        treeNode8.parent = treeNode5;
        treeNode9.parent = treeNode10;
        treeNode10.parent = treeNode8;
        treeNode11.parent = treeNode10;

        root = treeNode5;

        SearchTree searchTree = new SearchTree(treeNode5);

        TreeNode treeNode = searchTree.treePreDecessor(treeNode5);
        if (treeNode != null) {
            System.out.println("5的前驱是：" + treeNode.val);
        } else {
            System.out.println("5没有前驱。。。");
        }

        TreeNode treeNode4444 = searchTree.treePreDecessor(treeNode4);
        if (treeNode4444 != null) {
            System.out.println("4的前驱是：" + treeNode4444.val);
        } else {
            System.out.println("4没有前驱....");
        }

        TreeNode treeNode1111 = searchTree.treePreDecessor(treeNode1);
        if (treeNode1111 != null) {
            System.out.println("1的前驱是：" + treeNode1111.val);
        } else {
            System.out.println("1没有前驱....");
        }

        TreeNode treeNode6666 = searchTree.treePreDecessor(treeNode6);
        if (treeNode6666 != null) {
            System.out.println("6的前驱是：" + treeNode6666.val);
        } else {
            System.out.println("6没有前驱....");
        }

        TreeNode treeNode8888 = searchTree.treePreDecessor(treeNode8);
        if (treeNode8888 != null) {
            System.out.println("8的前驱是：" + treeNode8888.val);
        } else {
            System.out.println("8没有前驱....");
        }

        TreeNode treeNode818188 = searchTree.treePreDecessor(treeNode10);
        if (treeNode818188 != null) {
            System.out.println("10的前驱是：" + treeNode818188.val);
        } else {
            System.out.println("10没有前驱....");
        }
    }

    @Test
    public void insert() {
        SearchTree searchTree = new SearchTree();
        searchTree.insert(1);
        searchTree.insert(5);
        searchTree.insert(2);
        searchTree.insert(4);
        searchTree.insert(0);
        System.out.println(searchTree.insert(1));

        searchTree.inorderTreeWalk();

        DynamicArray<Integer> array = searchTree.toDynamicArray();
    }

    @Test
    public void transPlant() {
        SearchTree searchTree = new SearchTree();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;

        treeNode3.parent = treeNode2;
        treeNode2.parent = treeNode1;

        searchTree.setRoot(treeNode1);

        searchTree.transPlant(treeNode1, null);
        searchTree.transPlant(treeNode2, treeNode3);
    }

    @Test
    public void findNodeByValue() {
        Random random = new Random();
        SearchTree searchTree = new SearchTree();
        for (int i = 0; i < 10; i++) {
            searchTree.insert(random.nextInt(10));
        }

        TreeNode nodeByValue4 = searchTree.findNodeByValue(4);
        TreeNode nodeByValue5 = searchTree.findNodeByValue(5);
        TreeNode nodeByValue6 = searchTree.findNodeByValue(6);

    }

    @Test
    public void delete() {
        SearchTree searchTree = new SearchTree();
        searchTree.insert(7);
        searchTree.insert(8);
        searchTree.insert(9);
        searchTree.insert(2);
        searchTree.insert(1);
        searchTree.insert(5);
        searchTree.insert(3);
        searchTree.insert(4);


        System.out.println(searchTree.delete(2));
    }
}
