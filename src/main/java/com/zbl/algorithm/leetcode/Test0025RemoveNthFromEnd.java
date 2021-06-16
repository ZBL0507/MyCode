package com.zbl.algorithm.leetcode;

import com.zbl.ds.structure.ListNode;
import com.zbl.util.ListUtils;

/**
 * 删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
@SuppressWarnings("unused")
public class Test0025RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(6);
        ListNode listNode5 = new ListNode(5, listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListUtils.printList(listNode1);

        ListNode listNode = removeNthFromEnd(listNode1, 5);

        ListUtils.printList(listNode);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head)
            return null;
        int nodeCount = 0;

        ListNode p = head;
        for (; p != null; ) {
            nodeCount++;
            p = p.next;
        }

        p = head;
        int num = nodeCount - n;
        for (int i = 0; i < num - 1; i++)
            p = p.next;
        if (p == head) {
            if (nodeCount == 1)
                return null;
            if (num == 0)
                return head.next;
        }

        p.next = p.next.next;

        return head;
    }
}
