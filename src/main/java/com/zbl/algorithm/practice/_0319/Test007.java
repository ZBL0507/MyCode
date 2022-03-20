package com.zbl.algorithm.practice._0319;

/**
 * 快慢指针，寻求链表中点的位置
 */
public class Test007 {

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

        Node mid = findMinNode(n1);
        Node mid2 = findMinNode(n1);
    }

    public static Node findMinNode(Node node) {
        if (node == null) {
            return null;
        }

        Node s = node;
        Node q = node;

        while (q.next != null) {
            if (q.next.next != null) {
                q = q.next.next;
                s = s.next;
            } else {
                q = q.next;
                break;
            }
        }

        return s;
    }


    static class Node {
        int val;

        Node next;

        public Node(int v) {
            this.val = v;
        }

        public Node() {
        }
    }
}



