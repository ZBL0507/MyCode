package com.zbl.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvijdh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0036Connect {
    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node1.left = node2;
        node1.right = node3;

        Node connect = connect(node1);
    }

    private static Node connect(Node root) {
        if (root == null)
            return null;
        //分层， 拿到分层结果
        List<List<Node>> levelResult = process(root);
        //串联每层的指针
        for (List<Node> nodes : levelResult) {
            for (int i = 0; i < nodes.size() - 1; i++) {
                nodes.get(i).next = nodes.get(i + 1);
            }
        }
        return levelResult.get(0).get(0);
    }

    @SuppressWarnings("Duplicates")
    private static List<List<Node>> process(Node root) {
        Queue<Node> from = new LinkedList<>();
        Queue<Node> to = new LinkedList<>();
        List<List<Node>> levelResult = new ArrayList<>();

        from.add(root);
        while (!from.isEmpty() || !to.isEmpty()) {

            ArrayList<Node> curLevel = new ArrayList<>();
            ArrayList<Node> nextLevel = new ArrayList<>();

            while (!from.isEmpty()) {
                Node cur = from.poll();
                curLevel.add(cur);
                if (cur.left != null)
                    to.add(cur.left);
                if (cur.right != null)
                    to.add(cur.right);
            }
            if (!curLevel.isEmpty())
                levelResult.add(curLevel);

            while (!to.isEmpty()) {
                Node cur = to.poll();
                nextLevel.add(cur);
                if (cur.left != null)
                    from.add(cur.left);
                if (cur.right != null)
                    from.add(cur.right);
            }
            if (!nextLevel.isEmpty())
                levelResult.add(nextLevel);
        }

        return levelResult;
    }
}
