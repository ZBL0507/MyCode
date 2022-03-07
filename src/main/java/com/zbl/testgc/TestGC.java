package com.zbl.testgc;


import java.util.ArrayList;
import java.util.UUID;

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

    }

    private static void test003() {
        //java.lang.OutOfMemoryError: unable to create new native thread
        int count = 0;
        try {
            for (int i = 0;  ; i++) {
                int finalI = i;
                count = finalI;
                new Thread(() -> {
                    try {
                        //System.out.println("线程：" + finalI);
                        Thread.sleep(Integer.MAX_VALUE);
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("此时: " + count);
        }
    }

    private static void test002() {
        //vm参数 -XX:+PrintGCDetails -Xms10m -Xmx10m  -XX:+UseG1GC
        ArrayList<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(UUID.randomUUID().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    private static void test001() throws InterruptedException {
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
