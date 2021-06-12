package com.zbl.algorithm.leetcode;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnwzei/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0024HasCycle {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(44);
        ListNode listNode2 = new ListNode(55);
        ListNode listNode3 = new ListNode(66);
        ListNode listNode4 = new ListNode(77);
        ListNode listNode5 = new ListNode(88);
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode.next = listNode2;
        listNode5.next = listNode;

        hasCycle(listNode);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode quick = head.next == null ? null : head.next.next;
        boolean flag;
        for (; ; ) {
            if (slow == quick) {
                flag = true;
                break;
            }
            if (quick == null) {
                flag = false;
                break;
            }
            slow = slow.next;
            quick = quick.next == null ? null : quick.next.next;
        }

        return flag;
    }
}
