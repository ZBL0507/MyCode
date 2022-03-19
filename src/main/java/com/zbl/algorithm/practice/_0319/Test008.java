package com.zbl.algorithm.practice._0319;

/**
 * 单向链表逆序
 */
public class Test008 {
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n4.next = n5;
		n3.next = n4;
		n2.next = n3;
		n1.next = n2;

		Node nd = reverse(n1);
	}

	public static Node reverse(Node node) {
		Node p = node;
		Node q = node.next;
		p.next = null;
		Node next = null;

		while(q != null) {
			next = q.next;
			q.next = p;
			p = q;
			q = next;
		}

		return p;
	}


	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}
}
