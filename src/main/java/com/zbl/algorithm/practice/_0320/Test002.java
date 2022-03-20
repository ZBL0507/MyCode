package com.zbl.algorithm.practice._0320;

/**
 * 判断两个单向无环链表是否相交，
 * 如果不相交，返回null
 * 如果相交，返回相交的第一个节点
 */
public class Test002 {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);

		n4.next = n5;
		n3.next = n4;
		n2.next = n3;
		n1.next = n2;

		n6.next = n4;

		Node res = xiangJiaoNode(n1, n6);
	}

	public static Node xiangJiaoNode (Node h1, Node h2) {
		EndAndLength res1 = getEndAndLength(h1);
		EndAndLength res2 = getEndAndLength(h2);
		if (res1.length == 0 || res2.length == 0) {
			return null;
		}

		if (res1.end != res2.end) {
			return null;
		}

		Node p = res1.length > res2.length ? h1 : h2;
		Node q = p == h1 ? h2 : h1;

		int distance = Math.abs(res1.length - res2.length);

		for (int i = 0; i < distance; i++) {
			p = p.next;
		}

		while (p != q) {
			p = p.next;
			q = q.next;
		}

		return p;
	}


	public static EndAndLength getEndAndLength(Node head) {
		if (head == null) {
			return new EndAndLength();
		}


		int count = 0;
		Node p = head;

		while (p.next != null) {
			p = p.next;
			count++;
		}

		EndAndLength res = new EndAndLength();
		res.end = p;
		res.length = count + 1;

		return res;
	}


	static class EndAndLength {
		Node end;
		int length;
	}


	static class Node{
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}
}







