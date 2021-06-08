package com.zbl.util;

import com.zbl.ds.structure.ListNode;

@SuppressWarnings("unused")
public class ListUtils {
    public static void printList(final ListNode head) {
        ListNode p = head;
        for (; p != null; p = p.next)
            System.out.print(p.val + "  ");
        System.out.println();
    }
}
