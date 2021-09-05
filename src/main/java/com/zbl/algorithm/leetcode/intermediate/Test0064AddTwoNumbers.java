package com.zbl.algorithm.leetcode.intermediate;

import com.zbl.ds.structure.ListNode;

/**
 * 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @author zbl
 * @version 1.0
 * @since 2021/9/5 10:06
 */
public class Test0064AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);
        ListNode listNode7 = new ListNode(9);
        l1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        System.out.println("l1:" + l1);

        ListNode l2 = new ListNode(9);
        ListNode listNode8 = new ListNode(9);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(9);
        l2.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        System.out.println("l2:" + l2);

        ListNode res = addTwoNumbers(l1, l2);

        System.out.println("res:" + res);

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        //进位标志
        int flag = 0;
        ListNode r = null;
        ListNode result = null;

        while (p != null && q != null) {
            int res = p.val + q.val + flag;
            if (r == null) {
                r = new ListNode(res % 10);
                result = r;
            } else {
                r.next = new ListNode(res % 10);
                r = r.next;
            }
            flag = res / 10;
            p = p.next;
            q = q.next;
        }

        ListNode s = p != null ? p : q;
        while (s != null) {
            int res = s.val + flag;
            if (r == null) {
                r = new ListNode(res % 10);
                result = r;
            } else {
                r.next = new ListNode(res % 10);
                r = r.next;
            }
            flag = res / 10;
            s = s.next;
        }

        if (flag == 1) {
            r.next = new ListNode(1);
        }

        return result;
    }
}
