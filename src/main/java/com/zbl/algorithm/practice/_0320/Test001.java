package com.zbl.algorithm.practice._0320;

/**
 * 单向链表，
 * 如果有环，则返回入环的第一个节点，
 * 没有环，则返回null
 */
public class Test001 {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n5.next = n6;
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        n6.next = n3;

        Node res = getLoopNode(n1);
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node s = head.next;
        Node f = head.next.next;

        while (s != f && f != null) {
            f = f.next != null ? f.next.next : null;
            s = s.next;
        }

        if (f == null) {
            return null;
        }

        f = head;
        while (s != f) {
            s = s.next;
            f = f.next;
        }

        return s;
    }


    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}


