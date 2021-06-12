package com.zbl.algorithm.leetcode;

import java.util.Stack;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0023IsPalindrome {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(1);
        listNode2.next = listNode3;
        listNode1.next = listNode2;

        boolean palindrome = isPalindrome(listNode1);



    }

    private static boolean isPalindrome(ListNode head) {
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();
        for (; p != null; p = p.next) {
            stack.push(p.val);
        }
        for (; !stack.isEmpty() && head != null; head = head.next) {
            if (stack.pop() != head.val)
                return false;
        }
        return true;
    }


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

}
