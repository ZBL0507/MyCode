package com.zbl.algorithm.practice._0319;


/**
 * 单向链表的partition
 */
public class Test009 {

    public static void main(String[] args) {
        Node n1 = new Node(34);
        Node n2 = new Node(3);
        Node n3 = new Node(34);
        Node n4 = new Node(-1);
        Node n5 = new Node(-1);
        Node n6 = new Node(34);

        n5.next = n6;
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;

        Node res = partition(n1, 3);
    }

    public static Node partition(Node node, int key) {
        Node sHead = null;
        Node sTail = null;

        Node eHead = null;
        Node eTail = null;

        Node gHead = null;
        Node gTail = null;

        Node p = node;
        while (p != null) {
            if (p.val < key) {
                if (sHead == null) {
                    sHead = sTail = p;
                } else {
                    sTail.next = p;
                    sTail = sTail.next;
                }
            } else if (p.val > key) {
                if (gHead == null) {
                    gHead = gTail = p;
                } else {
                    gTail.next = p;
                    gTail = gTail.next;
                }
            } else {
                if (eHead == null) {
                    eHead = eTail = p;
                } else {
                    eTail.next = p;
                    eTail = eTail.next;
                }
            }

            p = p.next;
        }

        if (eTail != null) {
            eTail.next = gHead;
            if (sTail != null) {
                sTail.next = eHead;
            }
        } else {
            if (sTail != null) {
                sTail.next = gHead;
            }
        }

        if (sHead != null) {
            return sHead;
        }
        if (eHead != null) {
            return eHead;
        }
        return gHead;
    }


    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}






