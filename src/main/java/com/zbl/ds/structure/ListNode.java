package com.zbl.ds.structure;

@SuppressWarnings("unused")
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        ListNode p = this;
        while (p != null) {
            builder.append(p.val).append(", ");
            p = p.next;
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");

        return builder.toString();
    }
}