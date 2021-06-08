package com.zbl.testgc;


/**
 * -XX:InitialHeapSize=16777216
 * -XX:MaxHeapSize=16777216
 * -XX:+PrintCommandLineFlags
 * -XX:+PrintGCDetails
 * -XX:-UseLargePagesIndividualAllocation
 */
@SuppressWarnings("unused")
public class TestGC {
    public static void main(String[] args) throws InterruptedException {

        ListNode node1 = new ListNode(333);
        ListNode node2 = new ListNode(666);
        ListNode node3 = new ListNode(999);
        node1.next = node2;
        node2.next = node3;
        node2 = null;
        node3 = null;
        node1.next = node1.next.next;
        System.gc();

        System.out.println("hhh");
        byte[] bytes = new byte[5 * 1024 * 1024];
        Thread.sleep(Integer.MAX_VALUE);
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

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize..." + val);
        }
    }
}
