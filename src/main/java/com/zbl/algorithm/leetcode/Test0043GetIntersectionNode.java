package com.zbl.algorithm.leetcode;

import com.zbl.ds.structure.ListNode;

import java.util.HashSet;

/**
 * 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * @author zbl
 * @version 1.0
 * @since 2021/6/23 16:20
 */
public class Test0043GetIntersectionNode {
    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        System.out.println(listNode5);
        ListNode listNode6 = new ListNode(6);

        listNode5.next = listNode6;

        listNode2.next = listNode5;
        listNode3.next = listNode5;

        ListNode node = getIntersectionNode(listNode2, listNode3);

        System.out.println(node);
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
