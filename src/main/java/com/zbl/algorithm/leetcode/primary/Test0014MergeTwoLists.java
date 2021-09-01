package com.zbl.algorithm.leetcode.primary;

/*
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnbp2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

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
public class Test0014MergeTwoLists {
    class ListNode {
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

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = new ListNode();
        ListNode p = result;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.val = p1.val;
                p1 = p1.next;
                if (p1 != null) {
                    p.next = new ListNode();
                    p = p.next;
                }
            } else {
                p.val = p2.val;
                p2 = p2.next;
                if (p2 != null) {
                    p.next = new ListNode();
                    p = p.next;
                }
            }
        }

        while (p1 != null) {
            p.next = new ListNode();
            p = p.next;
            p.val = p1.val;
            p1 = p1.next;
        }

        while (p2 != null) {
            p.next = new ListNode();
            p = p.next;
            p.val = p2.val;
            p2 = p2.next;
        }
        return result;
    }
}
