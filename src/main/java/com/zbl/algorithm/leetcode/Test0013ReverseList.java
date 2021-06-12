package com.zbl.algorithm.leetcode;

/*
    反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
@SuppressWarnings("unused")
public class Test0013ReverseList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        ListNode node = reverseList2(node1);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        for (; p != null; ) {
            stack.push(p.val);
            p = p.next;
        }
        ListNode newHead = new ListNode();
        ListNode newP = newHead;
        while (!stack.isEmpty()) {
            newP.val = stack.pop();
            if (!stack.isEmpty()) {
                newP.next = new ListNode();
                newP = newP.next;
            }
        }
        return newHead;
    }

    private static ListNode reverseList2(ListNode head) {
        if (head == null)
            return null;

        ListNode result = new ListNode();
        ListNode[] nodes = new ListNode[1];
        nodes[0] = result;
        process(null, head, nodes);
        return nodes[0];
    }

    private static void process(ListNode pre, ListNode cur, ListNode[] nodes) {
        if (null == cur.next) {
            nodes[0] = cur;
            nodes[0].next = pre;
            return;
        }
        process(cur, cur.next, nodes);
        cur.next = pre;
    }
}
